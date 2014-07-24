package edu.zju.bme.clever.integration.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.zju.bme.clever.integration.entity.IntegrationQueue;
import edu.zju.bme.clever.integration.entity.mapper.mias.MiasPatientRowMapper;


@Service("integrationDispatcher")
@Transactional
public class IntegrationDispatcherImpl implements IntegrationDispatcher {

    @Resource(name="integrationService")
    private IntegrationService integrationService;
    @Resource(name="patientService")
    private PatientService patientService;

	@Override
	public void dispatch() {
		List<IntegrationQueue> iq = this.integrationService.getTop(1);
		iq.stream().map(i -> Optional.of(i)).forEach(this::dispatchIntegrationQueue);
	}
	
	private void dispatchIntegrationQueue(Optional<IntegrationQueue> iq) {
		if (iq.get().getTableName().compareTo(MiasPatientRowMapper.MASTER_PATIENT_INDEX.class.getSimpleName()) == 0) {
			this.patientService.integrate(iq.get().getLogicalKeyValue());
		}		
	}

}
