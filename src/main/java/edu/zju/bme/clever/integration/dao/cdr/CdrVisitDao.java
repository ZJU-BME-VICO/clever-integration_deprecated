package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Visit;

public interface CdrVisitDao {

	public List<Visit> get(String visitId);
	
	public int getCount(String visitId);
	
	public int save(Visit v);

}
