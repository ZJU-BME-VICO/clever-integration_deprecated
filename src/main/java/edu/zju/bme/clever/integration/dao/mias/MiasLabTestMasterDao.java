package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.LabTestMaster;

public interface MiasLabTestMasterDao {

	public List<LabTestMaster> get(String testId);

}
