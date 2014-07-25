package edu.zju.bme.clever.integration.service;

import java.util.List;

import edu.zju.bme.clever.integration.entity.IntegrationQueue;

public interface IntegrationService {
	
	public List<IntegrationQueue> getTop(int n);
	
	public void save(IntegrationQueue iq);

}
