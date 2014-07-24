package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Patient;

public interface CdrPatientDao {

	public List<Patient> get(String patientId);
	
	public int getCount(String patientId);
	
	public int save(Patient p);

}
