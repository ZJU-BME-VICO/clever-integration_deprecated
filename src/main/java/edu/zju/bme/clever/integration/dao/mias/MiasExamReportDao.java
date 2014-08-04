package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamReport;

public interface MiasExamReportDao {

	public List<ExamReport> get(int reportNo);

}
