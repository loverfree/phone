package com.newer.phone.service.back;

import java.util.List;

import com.newer.phone.pojo.Orders;

/**
 * ��̨����service��
 * @author Kiven
 *
 */
public interface OrderService {
	//�鿴����
	List<Orders> findAllOrders();
}