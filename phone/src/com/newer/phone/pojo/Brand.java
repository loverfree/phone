package com.newer.phone.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017��8��19�� ����3:30:42
 * 
 * Ʒ�Ʊ��ʵ�������--BRAND��
 * b_id:Ʒ�Ƶ�id
 * b_name:Ʒ����
 * b_status:Ʒ�Ƶ�״̬��0=�¼�  1=�¼�
 * b_logo:Ʒ�Ƶ�logoͼƬ��ַ
 * products:��Ʒ���µ�������Ʒ����
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
