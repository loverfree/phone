package com.newer.phone.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017��8��19�� ����3:54:07
 * 
 * ���۱��ʵ�������--REVIEW
 * r_id:������Ϣ��id
 * r_info:��������
 * product:���۵���Ʒ
 * user:д���۵��û�
 * r_time:д���۵�ʱ��   ϵͳĬ��ʱ��
 */
public class Review implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer r_id;
	private String r_info;
	private Product product;
	private User user;
	private Date r_time;

	public Integer getR_id() {
		return r_id;
	}

	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}

	public String getR_info() {
		return r_info;
	}

	public void setR_info(String r_info) {
		this.r_info = r_info;
	}

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

	public Date getR_time() {
		return r_time;
	}

	public void setR_time(Date r_time) {
		this.r_time = r_time;
	}

}
