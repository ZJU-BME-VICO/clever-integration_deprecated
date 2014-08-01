package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.LabTestMaster;

public interface CdrLabTestMasterDao {

	public List<LabTestMaster> get(String testId);
	
	public int getCount(String testId);
	
	public int save(LabTestMaster l);

}
