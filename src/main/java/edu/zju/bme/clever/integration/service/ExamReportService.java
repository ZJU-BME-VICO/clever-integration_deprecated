package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.ExamReport;

public interface ExamReportService {

	public Boolean integrate(int reportNo);
	
	public ExamReport cachedOrIntegrate(int key);
	
}
