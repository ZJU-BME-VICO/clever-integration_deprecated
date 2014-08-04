package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Allergy;

public interface CdrAllergyDao {

	public List<Allergy> get(int allergyId);
	
	public int getCount(int allergyId);
	
	public int save(Allergy a);

}
