package com.newer.phone.pojo;

import java.io.Serializable;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017年8月19日 下午3:35:46
 * 
 * 商品图片信息的实体对象类--IMAGE
 * i_id:该图片的id
 * i_path:该图片的存放地址
 * product:该图片所属的商品对象
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
