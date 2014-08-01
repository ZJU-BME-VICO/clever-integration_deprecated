package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.LabTestRequest;

public interface LabTestRequestService {

	public Boolean integrate(String testReqId);
	
	public LabTestRequest cachedOrIntegrate(String key);
	
}
