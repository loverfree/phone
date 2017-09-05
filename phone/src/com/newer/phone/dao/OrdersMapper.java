package com.newer.phone.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Orders;

/**
 * ����dao��
 * 
 * @author Kiven
 *
 */
@Repository
public interface OrdersMapper {

	/**
	 * ���ݵ�ǰ�û���id���鿴����û������ж�����4��״̬�Ķ�����
	 * @param u_id  �û�id
	 * @return  ��������
	 * @author samluby
	 */
	List<Orders> getOrderByUser(@Param("u_id") Integer u_id);

	/**
	 * ���ݵ�ǰ�û���id��ǰ�˴������Ķ���id��ɾ���ö���
	 * @param u_id �û�id
	 * @param o_id ����id
	 * @return
	 * @author samluby
	 */
	int removeOrderById(@Param("u_id") Integer u_id, @Param("o_id") Integer o_id);
	
	int addOrders(Orders order);
	
	Integer findOrder();
	
	int addPO(@Param("p_id")Integer p_id,
			  @Param("o_id")Integer o_id,
			  @Param("c_amount")Integer c_amount);
	List<Orders> findAll();
	List<Orders> findOne();
	List<Orders> findTwo();
	List<Orders> findThree();
	List<Orders> findFour();
}
