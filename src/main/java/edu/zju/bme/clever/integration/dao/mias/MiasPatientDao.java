package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Patient;

public interface MiasPatientDao {

	public List<Patient> get(String patientId);

}
