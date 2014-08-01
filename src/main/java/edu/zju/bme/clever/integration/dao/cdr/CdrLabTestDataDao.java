package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.LabTestData;

public interface CdrLabTestDataDao {

	public List<LabTestData> get(int testDataId);
	
	public int getCount(int testDataId);
	
	public int save(LabTestData l);

}
