package com.newer.phone.pojo;

import java.io.Serializable;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017年8月19日 下午3:46:06
 * 
 * 订单表和商品表多对多关系的关联表
 * product:商品对象
 * order:订单对象
 * c_amount:商品数量
 */
public class P_O implements Serializable {

	private static final long serialVersionUID = 1L;
	private Product product;
	private Orders order;
	private Integer c_amount;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Integer getC_amount() {
		return c_amount;
	}
	public void setC_amount(Integer c_amount) {
		this.c_amount = c_amount;
	}
	
	
}
