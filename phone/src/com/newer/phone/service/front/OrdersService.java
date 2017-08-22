package com.newer.phone.service.front;

import java.util.List;


import com.newer.phone.pojo.Orders;

public interface OrdersService {

	List<Orders> getOrderByUser(Integer u_id);
	
	int removeOrderById(Integer u_id,Integer o_id);
}
