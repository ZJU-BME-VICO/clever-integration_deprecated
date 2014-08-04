package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.ExamAction;

public interface ExamActionService {

	public Boolean integrate(int serialNo);
	
	public ExamAction cachedOrIntegrate(int key);
	
}
