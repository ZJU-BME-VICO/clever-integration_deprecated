package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.ExamItem;

public interface ExamItemService {

	public Boolean integrate(int serialNo);
	
	public ExamItem cachedOrIntegrate(int key);
	
}
