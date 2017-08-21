package com.newer.phone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.phone.pojo.Cart;

/**
 * 购物车表CART持久层
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017年8月20日 上午11:28:20
 */
@Repository
public interface CartMapper {

	/**
	 * 查看当前用户的购物车
	 * @param u_id 当前用户的id
	 * @return 购物车中的所有商品集合
	 */
	List<Cart> getCartByUser(@Param("u_id")Integer u_id);
	
	/**
	 * 添加商品到当前用户的购物车
	 * @param u_id 当前用户id
	 * @param p_id 选择商品的id
	 * @param c_amount 选择商品对的数量
	 * @return
	 * @author samluby
	 */
	int addCartByUser(@Param("u_id")Integer u_id,
			          @Param("p_id")Integer p_id,
			          @Param("c_amount")Integer c_amount);
	
	/**
	 * 根据用户id和商品id判断该购物车中是否已存在该商品
	 * @param u_id
	 * @param p_id
	 * @return
	 * @author samluby
	 */
	Cart getCartByUserAndProduct(@Param("u_id")Integer u_id,
			                     @Param("p_id")Integer p_id);

	/**
	 * 根据商品id去删除购物车中的商品
	 * @param p_id 商品id
	 * @param u_id 用户id
	 * @return
	 * @author samluby
	 */
	int removeCartByProduct(@Param("p_id")Integer p_id,
			                @Param("u_id")Integer u_id);
	
	int updateCartByProduct(@Param("p_id")Integer p_id,
			                @Param("u_id")Integer u_id,
			                @Param("c_amount")Integer c_amount);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

