package com.newer.phone.service.front;

import java.util.List;

import com.newer.phone.pojo.Cart;

public interface CartService {

	List<Cart> getCartByUser(Integer u_id);
	
	int addCartByUser(Integer u_id,Integer p_id,Integer c_amount);
	
	int removeCartByProduct(Integer p_id,Integer u_id);
	
	int updateCartByProduct(Integer p_id,Integer u_id,Integer c_amount);
	
	int removeCartAll(Integer u_id);
}