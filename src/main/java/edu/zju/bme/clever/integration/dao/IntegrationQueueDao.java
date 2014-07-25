package edu.zju.bme.clever.integration.dao;

import java.util.List;

import edu.zju.bme.clever.integration.entity.IntegrationQueue;

public interface IntegrationQueueDao {
	
	public List<IntegrationQueue> getTop(int n);

	public void save(IntegrationQueue iq);

}
