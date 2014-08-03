package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamData;

public interface CdrExamDataDao {

	public List<ExamData> get(int dataNo);
	
	public int getCount(int dataNo);
	
	public int save(ExamData e);

}
