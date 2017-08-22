package com.newer.phone.service.front.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.phone.dao.OrdersMapper;
import com.newer.phone.pojo.Orders;
import com.newer.phone.service.front.OrdersService;

@Service
public class OrderServiceImpl implements OrdersService{

	@Autowired
	private OrdersMapper ordersMapper;
	@Override
	public List<Orders> getOrderByUser(Integer u_id) {
		List<Orders> orders = ordersMapper.getOrderByUser(u_id);
		return orders;
	}

	@Override
	public int removeOrderById(Integer u_id, Integer o_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
