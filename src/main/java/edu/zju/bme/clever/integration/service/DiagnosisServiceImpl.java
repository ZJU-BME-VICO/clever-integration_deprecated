package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrDiagnosisDao;
import edu.zju.bme.clever.integration.dao.mias.MiasDiagnosisDao;
import edu.zju.bme.clever.integration.entity.Diagnosis;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("diagnosisService")
@Transactional
public class DiagnosisServiceImpl implements DiagnosisService {

    @Resource(name="miasDiagnosisDao")
    private MiasDiagnosisDao miasDiagnosisDao;
    @Resource(name="cdrDiagnosisDao")
    private CdrDiagnosisDao cdrDiagnosisDao;
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;
    
	@Override
	public Boolean integrate(int diagnosisId) {
		List<Diagnosis> vitalSigns = this.miasDiagnosisDao.get(diagnosisId);
		Boolean success = false;
		if (vitalSigns.size() == 1) {
			Diagnosis o = vitalSigns.get(0);
			
			Patient p = this.patientService.cachedOrIntegrate(o.getPatientId());
			if (p != null) {
				o.setIdPatient(p.get_hibernarmId());
			}
			
			Visit v = this.visitService.cachedOrIntegrate(o.getVisitId());
			if (v != null) {
				o.setIdVisit(v.get_hibernarmId());
			}

			if (this.cdrDiagnosisDao.save(o) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public Diagnosis cachedOrIntegrate(int key) {
		Diagnosis cachedKey = new Diagnosis();
		cachedKey.setDiagnosisId(key);
		Diagnosis cachedObject = (Diagnosis) CdrCache.INSTANCE.get(Diagnosis.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<Diagnosis> cdrObjects = this.cdrDiagnosisDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrDiagnosisDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}
		}
		return null;
	}

}
