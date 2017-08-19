package com.newer.phone.pojo;

import java.io.Serializable;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017��8��19�� ����3:35:46
 * 
 * ��ƷͼƬ��Ϣ��ʵ�������--IMAGE
 * i_id:��ͼƬ��id
 * i_path:��ͼƬ�Ĵ�ŵ�ַ
 * product:��ͼƬ��������Ʒ����
 */

public class Image implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer i_id;
	private String i_path;
	private Product product;

	public Integer getI_id() {
		return i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public String getI_path() {
		return i_path;
	}

	public void setI_path(String i_path) {
		this.i_path = i_path;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
