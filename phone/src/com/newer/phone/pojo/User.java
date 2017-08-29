package com.newer.phone.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017��8��19�� ����3:55:24
 * 
 * �û����ʵ�������--USER
 * u_id:�û�id
 * u_name:�û��ĵ�¼��   --�ֻ���
 * u_pwd:�û���¼������ --md5�㷨����
 * u_nickname:�û����ǳ�
 * u_pic:�û���ͷ��ͼƬ��ַ
 * u_card:�û������п���
 * addres:�û��������ջ���ַ
 * orders:�û����еĶ���  ���� 0=δ����  1=������  2=�ѷ���  3=���׳ɹ�
 * carts:�û��Ĺ��ﳵ
 * reviews:�û��������������
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
