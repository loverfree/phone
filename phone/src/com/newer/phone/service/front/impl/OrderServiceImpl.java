package com.newer.phone.service.front.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.newer.phone.dao.CartMapper;
import com.newer.phone.dao.OrdersMapper;
import com.newer.phone.dao.ProductMapper;
import com.newer.phone.pojo.Cart;
import com.newer.phone.pojo.Orders;
import com.newer.phone.service.front.OrdersService;

@Service
public class OrderServiceImpl implements OrdersService{

	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private ProductMapper productMapper;
	@Override
	public List<Orders> getOrderByUser(Integer u_id) {
		List<Orders> orders = ordersMapper.getOrderByUser(u_id);
		return orders;
	}

	@Override
	public int removeOrderById(Integer u_id, Integer o_id) {
		return ordersMapper.removeOrderById(u_id, o_id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public boolean addOrder(Orders order) {
		order.setO_time(new Date());
		order.setO_status(1);//付款了，未发货
		int isTrue = ordersMapper.addOrders(order);
		int isOp = 0;
		int isUp = 0;
//		Orders or = ordersMapper.findOrder(order.getO_time());
//		System.out.println(or.getO_id());
		Integer o_id = ordersMapper.findOrder();
		List<Cart> carts = cartMapper.getCartByUser(order.getUser().getU_id());
		System.out.println(carts.size());
		for (int i = 0; i < carts.size(); i++) {
			isOp = isOp+ordersMapper.addPO(carts.get(i).getProduct().getP_id(), o_id, carts.get(i).getC_amount());
			isUp = isUp+productMapper.updateProductByAmount(carts.get(i).getC_amount(), carts.get(i).getProduct().getP_id());
		}
		int isOK = cartMapper.removeCartAll(order.getUser().getU_id());
		if(isTrue>0 && isOK>0){
			return true;
		}
		return false;
	}

}
