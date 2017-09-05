package com.newer.phone.service.front;

import java.util.List;


import com.newer.phone.pojo.Orders;

public interface OrdersService {

	List<Orders> getOrderByUser(Integer u_id);
	
	int removeOrderById(Integer u_id,Integer o_id);

	boolean addOrder(Orders order);
	
	//用户处理确认订单
	List<Orders> confirmOrder(Integer u_id);

	//删除通知
	int confirmOk(Integer o_id);
}
