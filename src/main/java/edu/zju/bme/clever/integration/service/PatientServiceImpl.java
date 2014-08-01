package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrPatientDao;
import edu.zju.bme.clever.integration.dao.mias.MiasPatientDao;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {

    @Resource(name="miasPatientDao")
    private MiasPatientDao miasPatientDao;
    @Resource(name="cdrPatientDao")
    private CdrPatientDao cdrPatientDao;

	@Override
	public Boolean integrate(String patientId) {
		return this.integrate(this.miasPatientDao.get(patientId));
	}

	@Override
	public Boolean integrate(int serialNo) {
		return this.integrate(this.miasPatientDao.get(serialNo));
	}
	
	private Boolean integrate(List<Patient> patients) {
		Boolean success = false;
		if (patients.size() == 1) {
			Patient p = patients.get(0);
			if (this.cdrPatientDao.save(p) == 1) {
				success = true;
			}
		}
		
		return success;
		
	}

	@Override
	public Patient cachedOrIntegrate(String key) {
		Patient cachedKey = new Patient();
		cachedKey.setPatientId(key);
		Patient cachedObject = (Patient) CdrCache.INSTANCE.get(Patient.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<Patient> cdrObjects = this.cdrPatientDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrPatientDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

	@Override
	public Patient cachedOrIntegrate(int key) {
		Patient cachedKey = new Patient();
		cachedKey.setSerialNo(key);
		Patient cachedObject = (Patient) CdrCache.INSTANCE.get(Patient.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<Patient> cdrObjects = this.cdrPatientDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrPatientDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

}
