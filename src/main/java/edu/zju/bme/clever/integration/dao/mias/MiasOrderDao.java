package edu.zju.bme.clever.integration.dao.mias;

import java.util.List;

import edu.zju.bme.clever.integration.entity.Order;

public interface MiasOrderDao {

	public List<Order> get(int orderId);

}
