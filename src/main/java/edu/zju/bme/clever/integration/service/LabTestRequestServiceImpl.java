package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrLabTestRequestDao;
import edu.zju.bme.clever.integration.dao.mias.MiasLabTestRequestDao;
import edu.zju.bme.clever.integration.entity.LabTestRequest;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.entity.Visit;

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

	@Override
	public Boolean integrate(String testReqId) {
		List<LabTestRequest> labTestRequests = this.miasLabTestRequestDao.get(testReqId);
		Boolean success = false;
		if (labTestRequests.size() == 1) {
			LabTestRequest l = labTestRequests.get(0);
			
			Patient p = this.patientService.getCachedOrIntegratePatient(l.getPatientId());
			if (p != null) {
				l.setIdPatient(p.get_hibernarmId());
			}
			
			Visit v = this.visitService.getCachedOrIntegratePatient(l.getVisitId());
			if (v != null) {
				l.setIdVisit(v.get_hibernarmId());
			}

			if (this.cdrLabTestRequestDao.save(l) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

}
