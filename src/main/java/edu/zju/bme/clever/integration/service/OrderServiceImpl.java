package edu.zju.bme.clever.integration.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.dao.cdr.CdrOrderDao;
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
    @Resource(name="cdrOrderDao")
    private CdrOrderDao cdrOrderDao;    
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;

	@Override
	public Boolean integrate(int orderId) {
		List<Order> orders = this.miasOrderDao.get(orderId);
		Boolean success = false;
		if (orders.size() == 1) {
			Order o = orders.get(0);
			
			Patient p = this.patientService.cachedOrIntegrate(o.getPatientId());
			if (p != null) {
				o.setIdPatient(p.get_hibernarmId());
			}
			
			Visit v = this.visitService.cachedOrIntegrate(o.getVisitId());
			if (v != null) {
				o.setIdVisit(v.get_hibernarmId());
			}

			if (this.cdrOrderDao.save(o) == 1) {
				success = true;
			}			
		}
		
		return success;
	}

	@Override
	public Order cachedOrIntegrate(int key) {
		Order cachedKey = new Order();
		cachedKey.setOrderId(key);
		Order cachedObject = (Order) CdrCache.INSTANCE.get(Order.class, cachedKey.hashCode());
		if (cachedObject != null) {
			return cachedObject;
		} else {
			List<Order> cdrObjects = this.cdrOrderDao.get(key);
			if (!cdrObjects.isEmpty()) {
				return cdrObjects.get(0);
			} else {
				if (this.integrate(key)) {
					cdrObjects = this.cdrOrderDao.get(key);
					if (!cdrObjects.isEmpty()) {
						return cdrObjects.get(0);
					}
				}
			}					
		}
		return null;
	}

}
