package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrLabTestRequestDao;
import edu.zju.bme.clever.integration.dao.mias.MiasLabTestRequestDao;
import edu.zju.bme.clever.integration.entity.LabTestRequest;
import edu.zju.bme.clever.integration.entity.Order;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("labTestRequestService")
@Transactional
public class LabTestRequestServiceImpl implements LabTestRequestService {

    @Resource(name="miasLabTestRequestDao")
    private MiasLabTestRequestDao miasLabTestRequestDao;
    @Resource(name="cdrLabTestRequestDao")    
    private CdrLabTestRequestDao cdrLabTestRequestDao;
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;
    @Resource(name="orderService")
    private OrderService orderService;

	@Override
	public Boolean integrate(String testReqId) {
		List<LabTestRequest> labTestRequests = this.miasLabTestRequestDao.get(testReqId);
		Boolean success = false;
		if (labTestRequests.size() == 1) {
			LabTestRequest l = labTestRequests.get(0);
			
			Patient p = this.patientService.cachedOrIntegrate(l.getPatientId());
			if (p != null) {
				l.setIdPatient(p.get_hibernarmId());
			}
			
			Visit v = this.visitService.cachedOrIntegrate(l.getVisitId());
			if (v != null) {
				l.setIdVisit(v.get_hibernarmId());
			}
			
			if (l.getOrderId() != null) {
				Order o = this.orderService.cachedOrIntegrate(l.getOrderId());
				if (o != null) {
					l.setIdOrder(o.get_hibernarmId());
				}				
			}

			if (this.cdrLabTestRequestDao.save(l) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public LabTestRequest cachedOrIntegrate(String key) {
		LabTestRequest cachedKey = new LabTestRequest();
		cachedKey.setTestReqId(key);
		LabTestRequest cachedObject = (LabTestRequest) CdrCache.INSTANCE.get(LabTestRequest.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<LabTestRequest> cdrObjects = this.cdrLabTestRequestDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrLabTestRequestDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

}
