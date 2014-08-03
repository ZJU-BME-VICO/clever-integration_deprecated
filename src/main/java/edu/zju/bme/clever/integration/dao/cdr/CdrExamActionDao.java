package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamAction;

public interface CdrExamActionDao {

	public List<ExamAction> get(int serialNo);
	
	public int getCount(int serialNo);
	
	public int save(ExamAction e);

}
