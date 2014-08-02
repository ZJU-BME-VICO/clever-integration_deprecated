package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamMaster;

public interface CdrExamMasterDao {

//	public List<ExamMaster> get(int serialNo);

	public List<ExamMaster> get(String examId);
	
//	public int getCount(int serialNo);
	
	public int getCount(String examId);
	
	public int save(ExamMaster e);

}
