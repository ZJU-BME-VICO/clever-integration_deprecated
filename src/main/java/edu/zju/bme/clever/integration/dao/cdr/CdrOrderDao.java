package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Order;

public interface CdrOrderDao {

	public List<Order> get(int orderId);
	
	public int getCount(int orderId);
	
	public int save(Order o);

}
