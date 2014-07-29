package edu.zju.bme.clever.integration.dao.cdr;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Order;

public interface CdrOrderDao {

	public List<Order> get(Integer orderId);
	
	public int getCount(Integer orderId);
	
	public int save(Order o);

}
