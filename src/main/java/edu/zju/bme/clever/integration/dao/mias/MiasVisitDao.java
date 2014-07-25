package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Visit;

public interface MiasVisitDao {

	public List<Visit> get(String visitId);

}
