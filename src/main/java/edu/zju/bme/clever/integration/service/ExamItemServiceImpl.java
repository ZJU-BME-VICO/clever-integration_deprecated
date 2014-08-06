package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrExamItemDao;
import edu.zju.bme.clever.integration.dao.mias.MiasExamItemDao;
import edu.zju.bme.clever.integration.entity.ExamItem;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("examItemService")
@Transactional
public class ExamItemServiceImpl implements ExamItemService {

    @Resource(name="miasExamItemDao")
    private MiasExamItemDao miasExamItemDao;
    @Resource(name="cdrExamItemDao")    
    private CdrExamItemDao cdrExamItemDao;
    @Resource(name="examRequestService")
    private ExamRequestService examRequestService;
    @Resource(name="examMasterService")
    private ExamMasterService examMasterService;

	@Override
	public Boolean integrate(int serialNo) {
		List<ExamItem> examItems = this.miasExamItemDao.get(serialNo);
		Boolean success = false;
		if (examItems.size() == 1) {
			ExamItem e = examItems.get(0);
			
			this.examRequestService.cachedOrIntegrate(e.getExamReqId());
			
			this.examMasterService.cachedOrIntegrate(e.getExamId());

			if (this.cdrExamItemDao.save(e) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public ExamItem cachedOrIntegrate(int key) {
		ExamItem cachedKey = new ExamItem();
		cachedKey.setSerialNo(key);
		ExamItem cachedObject = (ExamItem) CdrCache.INSTANCE.get(ExamItem.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<ExamItem> cdrObjects = this.cdrExamItemDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrExamItemDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

}
