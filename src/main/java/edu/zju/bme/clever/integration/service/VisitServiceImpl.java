package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrPatientDao;
import edu.zju.bme.clever.integration.dao.cdr.CdrVisitDao;
import edu.zju.bme.clever.integration.dao.mias.MiasPatientLogDao;
import edu.zju.bme.clever.integration.dao.mias.MiasVisitDao;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.entity.Visit;

@Service("visitService")
@Transactional
public class VisitServiceImpl implements VisitService {

    @Resource(name="miasVisitDao")
    private MiasVisitDao miasVisitDao;
    @Resource(name="miasPatientLogDao")
    private MiasPatientLogDao miasPatientLogDao;
    @Resource(name="cdrPatientDao")
    private CdrPatientDao cdrPatientDao;
    @Resource(name="cdrVisitDao")
    private CdrVisitDao cdrVisitDao;
    @Resource(name="patientService")
    private PatientService patientService;
    
	@Override
	public Boolean integrate(String visitId) {
		List<Visit> visits = this.miasVisitDao.get(visitId);
		Boolean success = false;
		if (visits.size() == 1) {
			Visit v = visits.get(0);
			List<Patient> miasPatients = this.miasPatientLogDao.get(v.getMpimlSerialNo());
			if (!miasPatients.isEmpty()) {
				v.setMpimlSerialNo(miasPatients.get(0).getSerialNo());
				List<Patient> cdrPatients = this.cdrPatientDao.get(miasPatients.get(0).getSerialNo());
				if (!cdrPatients.isEmpty()) {
					v.setIdPatient(cdrPatients.get(0).get_hibernarmId());
					if (this.cdrVisitDao.save(v) == 1) {
						success = true;
					}
				} else {
					if (this.patientService.integrate(miasPatients.get(0).getSerialNo())) {
						cdrPatients = this.cdrPatientDao.get(miasPatients.get(0).getSerialNo());
						if (!cdrPatients.isEmpty()) {
							v.setIdPatient(cdrPatients.get(0).get_hibernarmId());
							if (this.cdrVisitDao.save(v) == 1) {
								success = true;
							}
						}
					}
				}
			}
		}
		
		return success;
	}

}
