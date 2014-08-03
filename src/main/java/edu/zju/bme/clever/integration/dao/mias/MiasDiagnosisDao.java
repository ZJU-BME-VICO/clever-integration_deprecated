package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Diagnosis;

public interface MiasDiagnosisDao {

	public List<Diagnosis> get(int diagnosisId);

}
