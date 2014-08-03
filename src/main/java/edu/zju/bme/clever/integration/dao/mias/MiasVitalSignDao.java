package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.VitalSign;

public interface MiasVitalSignDao {

	public List<VitalSign> get(Integer recordId);

}
