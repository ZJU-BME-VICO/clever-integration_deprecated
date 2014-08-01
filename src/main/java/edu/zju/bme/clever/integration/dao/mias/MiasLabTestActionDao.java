package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.LabTestAction;

public interface MiasLabTestActionDao {

	public List<LabTestAction> get(int serialNo);

}
