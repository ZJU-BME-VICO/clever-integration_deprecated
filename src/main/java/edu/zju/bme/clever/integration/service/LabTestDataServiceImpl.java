package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrLabTestDataDao;
import edu.zju.bme.clever.integration.dao.mias.MiasLabTestDataDao;
import edu.zju.bme.clever.integration.entity.LabTestData;

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
    @Resource(name="labTestMasterService")
    private LabTestMasterService labTestMasterService;

	@Override
	public Boolean integrate(int testDataId) {
		List<LabTestData> labTestDatas = this.miasLabTestDataDao.get(testDataId);
		Boolean success = false;
		if (labTestDatas.size() == 1) {
			LabTestData l = labTestDatas.get(0);
			
			this.patientService.cachedOrIntegrate(l.getPatientId());
			
			this.visitService.cachedOrIntegrate(l.getVisitId());
			
			this.labTestMasterService.cachedOrIntegrate(l.getTestId());

			if (this.cdrLabTestDataDao.save(l) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

}
