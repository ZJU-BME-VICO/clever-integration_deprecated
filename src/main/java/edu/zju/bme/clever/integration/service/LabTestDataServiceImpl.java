package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrLabTestDataDao;
import edu.zju.bme.clever.integration.dao.mias.MiasLabTestDataDao;
import edu.zju.bme.clever.integration.entity.LabTestData;
import edu.zju.bme.clever.integration.entity.LabTestMaster;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.entity.Visit;

@Service("labTestDataService")
@Transactional
public class LabTestDataServiceImpl implements LabTestDataService {

    @Resource(name="miasLabTestDataDao")
    private MiasLabTestDataDao miasLabTestDataDao;
    @Resource(name="cdrLabTestDataDao")    
    private CdrLabTestDataDao cdrLabTestDataDao;
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;
    @Resource(name="orderService")
    private OrderService orderService;
    @Resource(name="labTestMasterService")
    private LabTestMasterService labTestMasterService;

	@Override
	public Boolean integrate(int testDataId) {
		List<LabTestData> labTestDatas = this.miasLabTestDataDao.get(testDataId);
		Boolean success = false;
		if (labTestDatas.size() == 1) {
			LabTestData l = labTestDatas.get(0);
			
			Patient p = this.patientService.cachedOrIntegrate(l.getPatientId());
			if (p != null) {
				l.setIdPatient(p.get_hibernarmId());
			}
			
			Visit v = this.visitService.cachedOrIntegrate(l.getVisitId());
			if (v != null) {
				l.setIdVisit(v.get_hibernarmId());
			}
			
			LabTestMaster labTestMaster = this.labTestMasterService.cachedOrIntegrate(l.getTestId());
			if (labTestMaster != null) {
				l.setIdLabTestMaster(labTestMaster.get_hibernarmId());
			}

			if (this.cdrLabTestDataDao.save(l) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

}
