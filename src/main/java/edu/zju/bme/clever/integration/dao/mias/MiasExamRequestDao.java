package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamRequest;

public interface MiasExamRequestDao {

	public List<ExamRequest> get(String examReqId);

}
