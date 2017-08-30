package com.newer.phone.service.front.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.phone.dao.CartMapper;
import com.newer.phone.dao.ProductMapper;
import com.newer.phone.pojo.Cart;
import com.newer.phone.pojo.Product;
import com.newer.phone.service.front.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private ProductMapper productMapper;
	
	/**
	 * 查看购物车：根据前端传的参数用户id u_id，从session中获得，去查询CART中u_id=参数的所有记录。
	 * 返回Cart的Lise集合。
	 */
	@Override
	public List<Cart> getCartByUser(Integer u_id) {
		List<Cart> carts = cartMapper.getCartByUser(u_id);
		System.out.println("cartService:"+carts.size());
		return carts;
	}
	
	/**
	 * 添加商品到购物车：根据前端传的参数用户id和商品id去cart表中查询是否有此条记录，如有，则提示用户已添加该商品
	 * 没有，则u_id,p_id,c_amount去inset表cart中
	 */
	@Override
	public int addCartByUser(Integer u_id, Integer p_id, Integer c_amount) {
		System.out.println("开始查询");
		Cart cart = cartMapper.getCartByUserAndProduct(u_id, p_id);
		System.out.println("查询结束");
		if (cart==null) {
			return cartMapper.addCartByUser(u_id, p_id, c_amount);
		}
		return 0;
	}
	
	/**
	 * 删除用户的购物车中的商品。根据用户id和商品id去删除。where p_id=? and u_id=?
	 */
	@Override
	public int removeCartByProduct(Integer p_id, Integer u_id) {
		return cartMapper.removeCartByProduct(p_id,u_id);
	}

	/**
	 * 先根据商品id去PRODUCT表中查询商品是否还有这么多库存
	 * 有这么库存再根据用户id和商品id去更新数量
	 */
	@Override
	public int updateCartByProduct(Integer p_id, Integer u_id, Integer c_amount) {
		Product product = productMapper.findById(p_id);
		if(c_amount<=product.getP_stock()){
			return cartMapper.updateCartByProduct(p_id, u_id, c_amount);
		}
		return 0;
	}

	/**
	 * 根据用户id清空购物车
	 */
	@Override
	public int removeCartAll(Integer u_id) {
		return cartMapper.removeCartAll(u_id);
	}

}