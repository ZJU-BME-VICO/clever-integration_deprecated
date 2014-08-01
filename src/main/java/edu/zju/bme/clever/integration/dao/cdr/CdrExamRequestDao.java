package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamRequest;

public interface CdrExamRequestDao {

	public List<ExamRequest> get(String examReqId);
	
	public int getCount(String examReqId);
	
	public int save(ExamRequest e);

}
