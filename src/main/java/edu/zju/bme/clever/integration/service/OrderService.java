package edu.zju.bme.clever.integration.service;

import edu.zju.bme.clever.integration.entity.Order;

public interface OrderService {

	public Boolean integrate(int orderId);
	
	public Order cachedOrIntegrate(int key);
	
}
