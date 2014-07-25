package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrPatientDao;
import edu.zju.bme.clever.integration.dao.mias.MiasPatientDao;
import edu.zju.bme.clever.integration.entity.Patient;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {

    @Resource(name="miasPatientDao")
    private MiasPatientDao miasPatientDao;
    @Resource(name="cdrPatientDao")
    private CdrPatientDao cdrPatientDao;

	@Override
	public void integrate(String patientId) {
		List<Patient> patients = this.miasPatientDao.get(patientId);
		patients.forEach(p -> {
			this.cdrPatientDao.save(p);
		});
	}

	@Override
	public void integrate(int serialNo) {
		List<Patient> patients = this.miasPatientDao.get(serialNo);
		patients.forEach(p -> {
			this.cdrPatientDao.save(p);
		});
	}

}
