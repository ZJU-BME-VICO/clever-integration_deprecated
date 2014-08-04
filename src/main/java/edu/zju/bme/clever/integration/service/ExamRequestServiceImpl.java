package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrExamRequestDao;
import edu.zju.bme.clever.integration.dao.mias.MiasExamRequestDao;
import edu.zju.bme.clever.integration.entity.ExamRequest;
import edu.zju.bme.clever.integration.entity.Order;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("examRequestService")
@Transactional
public class ExamRequestServiceImpl implements ExamRequestService {

    @Resource(name="miasExamRequestDao")
    private MiasExamRequestDao miasExamRequestDao;
    @Resource(name="cdrExamRequestDao")    
    private CdrExamRequestDao cdrExamRequestDao;
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;
    @Resource(name="orderService")
    private OrderService orderService;

	@Override
	public Boolean integrate(String examReqId) {
		List<ExamRequest> examRequests = this.miasExamRequestDao.get(examReqId);
		Boolean success = false;
		if (examRequests.size() == 1) {
			ExamRequest e = examRequests.get(0);
			
			Patient p = this.patientService.cachedOrIntegrate(e.getPatientId());
			if (p != null) {
				e.setIdPatient(p.get_hibernarmId());
			}
			
			Visit v = this.visitService.cachedOrIntegrate(e.getVisitId());
			if (v != null) {
				e.setIdVisit(v.get_hibernarmId());
			}
			
			Order o = this.orderService.cachedOrIntegrate(e.getOrderId());
			if (o != null) {
				e.setIdOrder(o.get_hibernarmId());
			}

			if (this.cdrExamRequestDao.save(e) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public ExamRequest cachedOrIntegrate(String key) {
		ExamRequest cachedKey = new ExamRequest();
		cachedKey.setExamReqId(key);
		ExamRequest cachedObject = (ExamRequest) CdrCache.INSTANCE.get(ExamRequest.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<ExamRequest> cdrObjects = this.cdrExamRequestDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrExamRequestDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

}
