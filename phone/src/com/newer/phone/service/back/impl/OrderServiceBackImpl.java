package com.newer.phone.service.back.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.phone.dao.OrdersMapper;
import com.newer.phone.pojo.Orders;
import com.newer.phone.service.back.OrderServiceBack;
/**
 * 订单实现类
 * @author Kiven
 *
 */
@Service
public class OrderServiceBackImpl implements OrderServiceBack{
	
	@Autowired
	OrdersMapper orderMapper;
	@Override
	public List<Orders> findAllOrders() {
		return orderMapper.findAll();
	}
	
}
