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
}
