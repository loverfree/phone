package com.newer.phone.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Orders;

/**
 * 订单dao层
 * 
 * @author Kiven
 *
 */
@Repository
public interface OrdersMapper {

	/**
	 * 根据当前用户的id来查看这个用户的所有订单，4中状态的都包括
	 * @param u_id  用户id
	 * @return  订单集合
	 * @author samluby
	 */
	List<Orders> getOrderByUser(@Param("u_id") Integer u_id);

	/**
	 * 根据当前用户的id和前端传过来的订单id来删除该订单
	 * @param u_id 用户id
	 * @param o_id 订单id
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
