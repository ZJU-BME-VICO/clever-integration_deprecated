package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.LabTestMaster;

public interface LabTestMasterService {

	public Boolean integrate(String testId);
	
	public LabTestMaster cachedOrIntegrate(String key);
	
}
