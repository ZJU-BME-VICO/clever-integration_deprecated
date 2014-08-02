package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamItem;

public interface CdrExamItemDao {

	public List<ExamItem> get(int serialNo);
	
	public int getCount(int serialNo);
	
	public int save(ExamItem e);

}
