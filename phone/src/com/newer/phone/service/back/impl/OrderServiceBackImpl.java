package com.newer.phone.service.back.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public PageInfo<Orders> findAllOrders(Integer pageNo,Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null ? 5:pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<Orders> list = orderMapper.findAll();
		PageInfo<Orders> page = new PageInfo<Orders>(list);
		return page;
	}
	
}
