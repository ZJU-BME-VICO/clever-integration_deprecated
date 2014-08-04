package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Allergy;

public interface MiasAllergyDao {

	public List<Allergy> get(int allergyId);

}
