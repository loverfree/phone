package com.newer.phone.pojo;

import java.io.Serializable;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017年8月19日 下午3:33:56
 * 
 * 购物车表的实体对象类--CART表
 * product:该购物车中存在的一种商品
 * user:该购物车所属的用户对象
 * c_amount:购物车这种商品的数量
 */
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	private Product product;
	private User user;
	private Integer c_amount;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getC_amount() {
		return c_amount;
	}

	public void setC_amount(Integer c_amount) {
		this.c_amount = c_amount;
	}

}
