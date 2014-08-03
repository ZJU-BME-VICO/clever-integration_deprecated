package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrVitalSignDao;
import edu.zju.bme.clever.integration.dao.mias.MiasVitalSignDao;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.entity.VitalSign;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("vitalSignService")
@Transactional
public class VitalSignServiceImpl implements VitalSignService {

    @Resource(name="miasVitalSignDao")
    private MiasVitalSignDao miasVitalSignDao;
    @Resource(name="cdrVitalSignDao")
    private CdrVitalSignDao cdrVitalSignDao;
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;
    
	@Override
	public Boolean integrate(Integer recordId) {
		List<VitalSign> vitalSigns = this.miasVitalSignDao.get(recordId);
		Boolean success = false;
		if (vitalSigns.size() == 1) {
			VitalSign o = vitalSigns.get(0);
			
			Patient p = this.patientService.cachedOrIntegrate(o.getPatientId());
			if (p != null) {
				o.setIdPatient(p.get_hibernarmId());
			}
			
			Visit v = this.visitService.cachedOrIntegrate(o.getVisitId());
			if (v != null) {
				o.setIdVisit(v.get_hibernarmId());
			}

			if (this.cdrVitalSignDao.save(o) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public VitalSign cachedOrIntegrate(Integer key) {
		VitalSign cachedKey = new VitalSign();
		cachedKey.setRecordId(key);
		VitalSign cachedObject = (VitalSign) CdrCache.INSTANCE.get(VitalSign.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<VitalSign> cdrObjects = this.cdrVitalSignDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrVitalSignDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}
		}
		return null;
	}

}
