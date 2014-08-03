package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrExamDataDao;
import edu.zju.bme.clever.integration.dao.mias.MiasExamDataDao;
import edu.zju.bme.clever.integration.entity.ExamData;
import edu.zju.bme.clever.integration.entity.ExamMaster;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("examDataService")
@Transactional
public class ExamDataServiceImpl implements ExamDataService {

    @Resource(name="miasExamDataDao")
    private MiasExamDataDao miasExamDataDao;
    @Resource(name="cdrExamDataDao")    
    private CdrExamDataDao cdrExamDataDao;
    @Resource(name="examMasterService")
    private ExamMasterService examMasterService;

	@Override
	public Boolean integrate(int dataNo) {
		List<ExamData> examDatas = this.miasExamDataDao.get(dataNo);
		Boolean success = false;
		if (examDatas.size() == 1) {
			ExamData e = examDatas.get(0);
			
			ExamMaster examMaster = this.examMasterService.cachedOrIntegrate(e.getExamId());
			if (examMaster != null) {
				e.setIdExamMaster(examMaster.get_hibernarmId());
			}

			if (this.cdrExamDataDao.save(e) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public ExamData cachedOrIntegrate(int key) {
		ExamData cachedKey = new ExamData();
		cachedKey.setDataNo(key);
		ExamData cachedObject = (ExamData) CdrCache.INSTANCE.get(ExamData.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<ExamData> cdrObjects = this.cdrExamDataDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrExamDataDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

}
