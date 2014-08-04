package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.ExamMaster;

public interface ExamMasterService {

//	public Boolean integrate(int serialNo);

	public Boolean integrate(String examId);
	
//	public ExamMaster cachedOrIntegrate(int key);
	
	public ExamMaster cachedOrIntegrate(String key);
	
}
