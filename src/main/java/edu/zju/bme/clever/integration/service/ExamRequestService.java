package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.ExamRequest;

public interface ExamRequestService {

	public Boolean integrate(String examReqId);
	
	public ExamRequest cachedOrIntegrate(String key);
	
}
