package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Diagnosis;

public interface CdrDiagnosisDao {

	public List<Diagnosis> get(int diagnosisId);
	
	public int getCount(int diagnosisId);
	
	public int save(Diagnosis v);

}
