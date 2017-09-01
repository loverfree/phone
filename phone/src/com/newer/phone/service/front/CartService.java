package com.newer.phone.service.front;

import java.math.BigDecimal;
import java.util.List;


import com.newer.phone.pojo.Address;
import com.newer.phone.pojo.Cart;
import com.newer.phone.pojo.User;

public interface CartService {

	List<Cart> getCartByUser(Integer u_id);
	
	int addCartByUser(Integer u_id,Integer p_id,Integer c_amount);
	
	int removeCartByProduct(Integer p_id,Integer u_id);
	
	int updateCartByProduct(Integer p_id,Integer u_id,Integer c_amount);
	
	int removeCartAll(Integer u_id);
	
	boolean payByCart(User user,
            Address address,
            BigDecimal o_total);
}