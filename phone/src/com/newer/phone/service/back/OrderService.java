package com.newer.phone.service.back;

import java.util.List;

import com.newer.phone.pojo.Orders;

/**
 * 后台订单service层
 * @author Kiven
 *
 */
public interface OrderService {
	//查看订单
	List<Orders> findAllOrders();
}
