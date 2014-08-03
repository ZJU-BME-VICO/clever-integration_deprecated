package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.Diagnosis;

public interface DiagnosisService {

	public Boolean integrate(int diagnosisId);
	
	public Diagnosis cachedOrIntegrate(int key);
	
}
