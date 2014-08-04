package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.ExamData;

public interface MiasExamDataDao {

	public List<ExamData> get(int dataNo);

}
