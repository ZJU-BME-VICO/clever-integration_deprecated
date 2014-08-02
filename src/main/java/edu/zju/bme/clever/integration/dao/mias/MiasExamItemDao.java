package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamItem;

public interface MiasExamItemDao {

	public List<ExamItem> get(int serialNo);

}
