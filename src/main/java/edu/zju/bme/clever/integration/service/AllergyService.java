package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.Allergy;

public interface AllergyService {

	public Boolean integrate(int allergyId);
	
	public Allergy cachedOrIntegrate(int key);
	
}
