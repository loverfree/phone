package com.newer.phone.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017年8月19日 下午3:30:42
 * 
 * 品牌表的实体对象类--BRAND表
 * b_id:品牌的id
 * b_name:品牌名
 * b_status:品牌的状态：0=下架  1=下架
 * b_logo:品牌的logo图片地址
 * products:该品牌下的所有商品集合
 */
public class Brand implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer b_id;
	private String b_name;
	private Integer b_status;
	private String b_logo;
	private List<Product> products;

	public Integer getB_id() {
		return b_id;
	}

	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public Integer getB_status() {
		return b_status;
	}

	public void setB_status(Integer b_status) {
		this.b_status = b_status;
	}

	public String getB_logo() {
		return b_logo;
	}

	public void setB_logo(String b_logo) {
		this.b_logo = b_logo;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
