package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.ExamData;

public interface ExamDataService {

	public Boolean integrate(int dataNo);
	
	public ExamData cachedOrIntegrate(int key);
	
}
