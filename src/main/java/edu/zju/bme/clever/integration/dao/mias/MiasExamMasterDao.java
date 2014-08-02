package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamMaster;

public interface MiasExamMasterDao {

//	public List<ExamMaster> get(int serialNo);

	public List<ExamMaster> get(String examId);

}
