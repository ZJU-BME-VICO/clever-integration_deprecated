package edu.zju.bme.clever.integration.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.entity.IntegrationQueue;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasOrderRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasPatientRowMapper;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasVisitRowMapper;


@Service("integrationDispatcher")
@Transactional
public class IntegrationDispatcherImpl implements IntegrationDispatcher {

	private static Logger logger = Logger.getLogger(IntegrationDispatcherImpl.class.getName());

    @Resource(name="integrationService")
    private IntegrationService integrationService;
    @Resource(name="patientService")
    private PatientService patientService;
    @Resource(name="visitService")
    private VisitService visitService;
    @Resource(name="orderService")
    private OrderService orderService;

	@Override
	public void dispatch() {
		List<IntegrationQueue> iq = this.integrationService.getTop(1);
		iq.stream().map(i -> Optional.of(i)).forEach(this::dispatchIntegrationQueue);
	}
	
	private void dispatchIntegrationQueue(Optional<IntegrationQueue> iq) {
		try {
			iq.get().setStatus(false);
			if (iq.get().getTableName().compareTo(MiasPatientRowMapper.MASTER_PATIENT_INDEX.class.getSimpleName()) == 0) {
				if (this.patientService.integrate(iq.get().getLogicalKeyValue())) {
					iq.get().setStatus(true);
				}
			} else if (iq.get().getTableName().compareTo(MiasVisitRowMapper.PATIENT_VISIT.class.getSimpleName()) == 0) {
				if (this.visitService.integrate(iq.get().getLogicalKeyValue())) {
					iq.get().setStatus(true);
				}			
			} else if (iq.get().getTableName().compareTo(MiasOrderRowMapper.ORDERS.class.getSimpleName()) == 0) {
				if (this.orderService.integrate(Integer.parseInt(iq.get().getLogicalKeyValue()))) {
					iq.get().setStatus(true);
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		
		this.integrationService.save(iq.get());
	}

}
