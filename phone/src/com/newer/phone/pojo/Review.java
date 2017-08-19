package com.newer.phone.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017年8月19日 下午3:54:07
 * 
 * 评论表的实体对象类--REVIEW
 * r_id:评论信息的id
 * r_info:评论内容
 * product:评论的商品
 * user:写评论的用户
 * r_time:写评论的时间   系统默认时间
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
