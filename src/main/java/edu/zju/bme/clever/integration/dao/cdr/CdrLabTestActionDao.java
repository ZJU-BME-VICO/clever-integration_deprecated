package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.LabTestAction;

public interface CdrLabTestActionDao {

	public List<LabTestAction> get(int serialNo);
	
	public int getCount(int serialNo);
	
	public int save(LabTestAction l);

}
