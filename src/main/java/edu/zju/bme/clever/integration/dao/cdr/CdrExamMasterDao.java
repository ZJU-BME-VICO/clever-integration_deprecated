package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamMaster;

public interface CdrExamMasterDao {

	public List<ExamMaster> get(int serialNo);
	
	public int getCount(int serialNo);
	
	public int save(ExamMaster e);

}
