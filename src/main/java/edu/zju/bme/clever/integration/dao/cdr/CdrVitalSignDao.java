package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.VitalSign;

public interface CdrVitalSignDao {

	public List<VitalSign> get(int recordId);
	
	public int getCount(int recordId);
	
	public int save(VitalSign v);

}
