package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrOrderDao;
import edu.zju.bme.clever.integration.dao.cdr.CdrPatientDao;
import edu.zju.bme.clever.integration.dao.cdr.CdrVisitDao;
import edu.zju.bme.clever.integration.dao.mias.MiasOrderDao;
import edu.zju.bme.clever.integration.entity.Order;
import edu.zju.bme.clever.integration.entity.Patient;
import edu.zju.bme.clever.integration.entity.Visit;
import edu.zju.bme.clever.integration.util.CdrCache;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Resource(name="miasOrderDao")
    private MiasOrderDao miasOrderDao;
    @Resource(name="cdrPatientDao")
    private CdrPatientDao cdrPatientDao;
    @Resource(name="cdrVisitDao")
    private CdrVisitDao cdrVisitDao;
    @Resource(name="cdrOrderDao")
    private CdrOrderDao cdrOrderDao;    
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;

	@Override
	public Boolean integrate(Integer orderId) {
		List<Order> orders = this.miasOrderDao.get(orderId);
		Boolean success = false;
		if (orders.size() == 1) {
			Order o = orders.get(0);

			Patient cachedPatientKey = new Patient();
			cachedPatientKey.setPatientId(o.getPatientId());
			Patient cachedPatient = (Patient) CdrCache.INSTANCE.get(Patient.class, cachedPatientKey.hashCode());
			if (cachedPatient != null) {
				o.setIdPatient(cachedPatient.get_hibernarmId());
			} else {
				List<Patient> cdrPatients = this.cdrPatientDao.get(o.getPatientId());
				if (!cdrPatients.isEmpty()) {
					o.setIdPatient(cdrPatients.get(0).get_hibernarmId());
				} else {
					if (this.patientService.integrate(o.getPatientId())) {
						cdrPatients = this.cdrPatientDao.get(o.getPatientId());
						if (!cdrPatients.isEmpty()) {
							o.setIdPatient(cdrPatients.get(0).get_hibernarmId());
						}
					}
				}					
			}
			
			Visit cachedVisitKey = new Visit();
			cachedVisitKey.setVisitId(o.getVisitId());
			Visit cachedVisit = (Visit) CdrCache.INSTANCE.get(Visit.class, cachedVisitKey.hashCode());
			if (cachedVisit != null) {
				o.setIdVisit(cachedVisit.get_hibernarmId());
			} else {
				List<Visit> cdrVisits = this.cdrVisitDao.get(o.getVisitId());
				if (!cdrVisits.isEmpty()) {
					o.setIdVisit(cdrVisits.get(0).get_hibernarmId());
				} else {
					if (this.visitService.integrate(o.getVisitId())) {
						cdrVisits = this.cdrVisitDao.get(o.getVisitId());
						if (!cdrVisits.isEmpty()) {
							o.setIdVisit(cdrVisits.get(0).get_hibernarmId());
						}
					}
				}
			}

			if (this.cdrOrderDao.save(o) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

}
