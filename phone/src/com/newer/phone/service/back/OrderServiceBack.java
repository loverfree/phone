package com.newer.phone.service.back;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.Orders;

/**
 * 后台订单service层
 * @author Kiven
 *
 */
public interface OrderServiceBack {
	//查看订单
	PageInfo<Orders> findAllOrders(Integer pageNo,Integer pageSize);
}
