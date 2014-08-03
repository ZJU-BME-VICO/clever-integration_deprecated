package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.VitalSign;

public interface CdrVitalSignDao {

	public List<VitalSign> get(Integer recordId);
	
	public int getCount(Integer recordId);
	
	public int save(VitalSign v);

}
