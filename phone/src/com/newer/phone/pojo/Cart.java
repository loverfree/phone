package com.newer.phone.pojo;

import java.io.Serializable;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017��8��19�� ����3:33:56
 * 
 * ���ﳵ���ʵ�������--CART��
 * product:�ù��ﳵ�д��ڵ�һ����Ʒ
 * user:�ù��ﳵ�������û�����
 * c_amount:���ﳵ������Ʒ������
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
