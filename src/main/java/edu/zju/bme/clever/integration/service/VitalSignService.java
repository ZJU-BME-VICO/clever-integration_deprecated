package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.VitalSign;

public interface VitalSignService {

	public Boolean integrate(int recordId);
	
	public VitalSign cachedOrIntegrate(int key);
	
}
