package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrAllergyDao;
import edu.zju.bme.clever.integration.dao.mias.MiasAllergyDao;
import edu.zju.bme.clever.integration.entity.Allergy;
import edu.zju.bme.clever.integration.entity.Order;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("allergyService")
@Transactional
public class AllergyServiceImpl implements AllergyService {

    @Resource(name="miasAllergyDao")
    private MiasAllergyDao miasAllergyDao;
    @Resource(name="cdrAllergyDao")
    private CdrAllergyDao cdrAllergyDao;
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;
    @Resource(name="orderService")
    private OrderService orderService;
    
	@Override
	public Boolean integrate(int allergyId) {
		List<Allergy> allergies = this.miasAllergyDao.get(allergyId);
		Boolean success = false;
		if (allergies.size() == 1) {
			Allergy a = allergies.get(0);
			
			Patient p = this.patientService.cachedOrIntegrate(a.getPatientId());
			if (p != null) {
				a.setIdPatient(p.get_hibernarmId());
			}
			
			Visit v = this.visitService.cachedOrIntegrate(a.getVisitId());
			if (v != null) {
				a.setIdVisit(v.get_hibernarmId());
			}
			
			if (a.getOrderId() != null) {
				Order o = this.orderService.cachedOrIntegrate(a.getOrderId());
				if (o != null) {
					a.setIdOrder(o.get_hibernarmId());
				}				
			}

			if (this.cdrAllergyDao.save(a) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public Allergy cachedOrIntegrate(int key) {
		Allergy cachedKey = new Allergy();
		cachedKey.setAllergyId(key);
		Allergy cachedObject = (Allergy) CdrCache.INSTANCE.get(Allergy.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<Allergy> cdrObjects = this.cdrAllergyDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrAllergyDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}
		}
		return null;
	}

}
