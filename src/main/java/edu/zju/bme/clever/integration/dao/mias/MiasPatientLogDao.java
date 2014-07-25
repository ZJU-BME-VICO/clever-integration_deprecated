package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Patient;

public interface MiasPatientLogDao {

	public List<Patient> get(int serialNo);

}
