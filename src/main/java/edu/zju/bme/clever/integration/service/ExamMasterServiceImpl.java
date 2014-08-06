package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrExamMasterDao;
import edu.zju.bme.clever.integration.dao.mias.MiasExamMasterDao;
import edu.zju.bme.clever.integration.entity.ExamMaster;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("examMasterService")
@Transactional
public class ExamMasterServiceImpl implements ExamMasterService {

    @Resource(name="miasExamMasterDao")
    private MiasExamMasterDao miasExamMasterDao;
    @Resource(name="cdrExamMasterDao")    
    private CdrExamMasterDao cdrExamMasterDao;
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;
    @Resource(name="examRequestService")
    private ExamRequestService examRequestService;

//	@Override
//	public Boolean integrate(int serialNo) {
//		List<ExamMaster> examMasters = this.miasExamMasterDao.get(serialNo);
//		Boolean success = false;
//		if (examMasters.size() == 1) {
//			ExamMaster e = examMasters.get(0);
//			
//			Patient p = this.patientService.cachedOrIntegrate(e.getPatientId());
//			if (p != null) {
//				e.setIdPatient(p.get_hibernarmId());
//			}
//			
//			Visit v = this.visitService.cachedOrIntegrate(e.getVisitId());
//			if (v != null) {
//				e.setIdVisit(v.get_hibernarmId());
//			}
//			
//			ExamRequest examRequest = this.examRequestService.cachedOrIntegrate(e.getExamReqId());
//			if (examRequest != null) {
//				e.setIdExamRequest(examRequest.get_hibernarmId());
//			}
//
//			if (this.cdrExamMasterDao.save(e) == 1) {
//				success = true;
//			}			
//		}
//		
//		return success;
//	}

	@Override
	public Boolean integrate(String examId) {
		List<ExamMaster> examMasters = this.miasExamMasterDao.get(examId);
		Boolean success = false;
		if (examMasters.size() == 1) {
			ExamMaster e = examMasters.get(0);
			
			this.patientService.cachedOrIntegrate(e.getPatientId());
			
			this.visitService.cachedOrIntegrate(e.getVisitId());
			
			this.examRequestService.cachedOrIntegrate(e.getExamReqId());

			if (this.cdrExamMasterDao.save(e) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

//	@Override
//	public ExamMaster cachedOrIntegrate(int key) {
//		ExamMaster cachedKey = new ExamMaster();
//		cachedKey.setSerialNo(key);
//		ExamMaster cachedObject = (ExamMaster) CdrCache.INSTANCE.get(ExamMaster.class, cachedKey.hashCode());
//		if (cachedObject != null) {
//			return cachedObject;
//		} else {
//			List<ExamMaster> cdrObjects = this.cdrExamMasterDao.get(key);
//			if (!cdrObjects.isEmpty()) {
//				return cdrObjects.get(0);
//			} else {
//				if (this.integrate(key)) {
//					cdrObjects = this.cdrExamMasterDao.get(key);
//					if (!cdrObjects.isEmpty()) {
//						return cdrObjects.get(0);
//					}
//				}
//			}					
//		}
//		return null;
//	}

	@Override
	public ExamMaster cachedOrIntegrate(String key) {
		ExamMaster cachedKey = new ExamMaster();
		cachedKey.setExamId(key);
		ExamMaster cachedObject = (ExamMaster) CdrCache.INSTANCE.get(ExamMaster.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<ExamMaster> cdrObjects = this.cdrExamMasterDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrExamMasterDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

}
