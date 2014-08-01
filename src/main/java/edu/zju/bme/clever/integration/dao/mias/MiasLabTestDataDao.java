package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.LabTestData;

public interface MiasLabTestDataDao {

	public List<LabTestData> get(int testDataId);

}
