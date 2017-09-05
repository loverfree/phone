package com.newer.phone.service.front;

import java.util.List;


import com.newer.phone.pojo.Orders;

public interface OrdersService {

	List<Orders> getOrderByUser(Integer u_id);
	
	int removeOrderById(Integer u_id,Integer o_id);

	boolean addOrder(Orders order);
	
	//�û�����ȷ�϶���
	List<Orders> confirmOrder(Integer u_id);

	//ɾ��֪ͨ
	int confirmOk(Integer o_id);
	
	//���¶���״̬
	int updateStatus(Integer o_status,Integer o_id);

	//����֪ͨ
	int setInform(int i, Integer o_id);
}
