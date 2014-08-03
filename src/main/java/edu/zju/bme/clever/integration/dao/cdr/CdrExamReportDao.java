package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamReport;

public interface CdrExamReportDao {

	public List<ExamReport> get(int reportNo);
	
	public int getCount(int reportNo);
	
	public int save(ExamReport e);

}
