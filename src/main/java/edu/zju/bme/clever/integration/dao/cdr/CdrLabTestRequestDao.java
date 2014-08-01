package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.LabTestRequest;

public interface CdrLabTestRequestDao {

	public List<LabTestRequest> get(String testReqId);
	
	public int getCount(String testReqId);
	
	public int save(LabTestRequest l);

}
