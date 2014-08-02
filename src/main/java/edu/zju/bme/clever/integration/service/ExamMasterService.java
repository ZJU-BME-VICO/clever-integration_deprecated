package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.ExamMaster;

public interface ExamMasterService {

	public Boolean integrate(int serialNo);
	
	public ExamMaster cachedOrIntegrate(int key);
	
}
