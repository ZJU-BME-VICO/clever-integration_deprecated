package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamAction;

public interface MiasExamActionDao {

	public List<ExamAction> get(int serialNo);

}
