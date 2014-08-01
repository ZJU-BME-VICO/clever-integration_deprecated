package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrLabTestMasterDao;
import edu.zju.bme.clever.integration.dao.mias.MiasLabTestMasterDao;
import edu.zju.bme.clever.integration.entity.LabTestMaster;
import edu.zju.bme.clever.integration.entity.LabTestRequest;
import edu.zju.bme.clever.integration.entity.Order;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("labTestMasterService")
@Transactional
public class LabTestMasterServiceImpl implements LabTestMasterService {

    @Resource(name="miasLabTestMasterDao")
    private MiasLabTestMasterDao miasLabTestMasterDao;
    @Resource(name="cdrLabTestMasterDao")    
    private CdrLabTestMasterDao cdrLabTestMasterDao;
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;
    @Resource(name="orderService")
    private OrderService orderService;
    @Resource(name="labTestRequestService")
    private LabTestRequestService labTestRequestService;

	@Override
	public Boolean integrate(String testId) {
		List<LabTestMaster> labTestMasters = this.miasLabTestMasterDao.get(testId);
		Boolean success = false;
		if (labTestMasters.size() == 1) {
			LabTestMaster l = labTestMasters.get(0);
			
			Patient p = this.patientService.cachedOrIntegrate(l.getPatientId());
			if (p != null) {
				l.setIdPatient(p.get_hibernarmId());
			}
			
			Visit v = this.visitService.cachedOrIntegrate(l.getVisitId());
			if (v != null) {
				l.setIdVisit(v.get_hibernarmId());
			}
			
			Order o = this.orderService.cachedOrIntegrate(l.getOrderId());
			if (o != null) {
				l.setIdOrder(o.get_hibernarmId());
			}
			
			LabTestRequest labTestRequest = this.labTestRequestService.cachedOrIntegrate(l.getTestReqId());
			if (labTestRequest != null) {
				l.setIdLabTestRequest(labTestRequest.get_hibernarmId());
			}

			if (this.cdrLabTestMasterDao.save(l) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public LabTestMaster cachedOrIntegrate(String key) {
		LabTestMaster cachedKey = new LabTestMaster();
		cachedKey.setTestReqId(key);
		LabTestMaster cachedObject = (LabTestMaster) CdrCache.INSTANCE.get(LabTestMaster.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<LabTestMaster> cdrObjects = this.cdrLabTestMasterDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrLabTestMasterDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

}
