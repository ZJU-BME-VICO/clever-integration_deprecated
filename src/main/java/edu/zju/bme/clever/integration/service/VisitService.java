package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.Visit;

public interface VisitService {

	public Boolean integrate(String visitId);
	
	public Visit getCachedOrIntegratePatient(String visitId);
	
}
