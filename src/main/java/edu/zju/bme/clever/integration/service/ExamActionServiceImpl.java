package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrExamActionDao;
import edu.zju.bme.clever.integration.dao.mias.MiasExamActionDao;
import edu.zju.bme.clever.integration.entity.ExamAction;
import edu.zju.bme.clever.integration.entity.ExamMaster;
import edu.zju.bme.clever.integration.entity.ExamRequest;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("examActionService")
@Transactional
public class ExamActionServiceImpl implements ExamActionService {

    @Resource(name="miasExamActionDao")
    private MiasExamActionDao miasExamActionDao;
    @Resource(name="cdrExamActionDao")    
    private CdrExamActionDao cdrExamActionDao;
    @Resource(name="examRequestService")
    private ExamRequestService examRequestService;
    @Resource(name="examMasterService")
    private ExamMasterService examMasterService;

	@Override
	public Boolean integrate(int serialNo) {
		List<ExamAction> examDatas = this.miasExamActionDao.get(serialNo);
		Boolean success = false;
		if (examDatas.size() == 1) {
			ExamAction e = examDatas.get(0);
			
			ExamRequest examRequest = this.examRequestService.cachedOrIntegrate(e.getExamReqId());
			if (examRequest != null) {
				e.setIdExamRequest(examRequest.get_hibernarmId());
			}
			
			ExamMaster examMaster = this.examMasterService.cachedOrIntegrate(e.getExamId());
			if (examMaster != null) {
				e.setIdExamMaster(examMaster.get_hibernarmId());
			}

			if (this.cdrExamActionDao.save(e) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public ExamAction cachedOrIntegrate(int key) {
		ExamAction cachedKey = new ExamAction();
		cachedKey.setSerialNo(key);
		ExamAction cachedObject = (ExamAction) CdrCache.INSTANCE.get(ExamAction.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<ExamAction> cdrObjects = this.cdrExamActionDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrExamActionDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

}
