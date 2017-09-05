package com.newer.phone.service.back;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.newer.phone.pojo.Orders;

/**
 * ��̨����service��
 * @author Kiven
 *
 */
public interface OrderServiceBack {
	//�鿴����
	PageInfo<Orders> findAllOrders(Integer pageNo,Integer pageSize);
	PageInfo<Orders> findOrdersOne(Integer pageNo,Integer pageSize);
	PageInfo<Orders> findOrdersTwo(Integer pageNo,Integer pageSize);
	PageInfo<Orders> findOrdersThree(Integer pageNo,Integer pageSize);
	PageInfo<Orders> findOrdersFour(Integer pageNo,Integer pageSize);
}
