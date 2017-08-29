package com.newer.phone.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017年8月19日 下午3:55:24
 * 
 * 用户表的实体对象类--USER
 * u_id:用户id
 * u_name:用户的登录名   --手机号
 * u_pwd:用户登录的密码 --md5算法处理
 * u_nickname:用户的昵称
 * u_pic:用户的头像图片地址
 * u_card:用户的银行卡号
 * addres:用户的所有收货地址
 * orders:用户所有的订单  包括 0=未付款  1=待发货  2=已发货  3=交易成功
 * carts:用户的购物车
 * reviews:用户发表的所有评论
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer u_id;
	private String u_name;
	private String u_pwd;
	private String u_nickname;
	private String u_pic;
	private String u_card;
	private List<Address> addresses;
	private List<Orders> orders;
	private List<Cart> carts;
	private List<Review> reviews;

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_nickname() {
		return u_nickname;
	}

	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}

	public String getU_pic() {
		return u_pic;
	}

	public void setU_pic(String u_pic) {
		this.u_pic = u_pic;
	}

	public String getU_card() {
		return u_card;
	}

	public void setU_card(String u_card) {
		this.u_card = u_card;
	}

	public List<Address> getAddres() {
		return addresses;
	}

	public void setAddres(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
