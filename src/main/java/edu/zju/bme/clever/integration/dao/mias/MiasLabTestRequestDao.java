package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.LabTestRequest;

public interface MiasLabTestRequestDao {

	public List<LabTestRequest> get(String testReqId);

}
