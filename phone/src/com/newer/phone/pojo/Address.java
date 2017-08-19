package com.newer.phone.pojo;

import java.io.Serializable;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017年8月19日 下午3:27:19
 * 
 * 地址表的实体对象类--ADDRESS表
 * a_id：地址id
 * a_province:收件地址省份
 * a_city:收件地址城市
 * a_street:收件地址街道详细信息
 * a_recv:收件人姓名
 * a_recvtel:收件人手机号码
 * user:关联的用户对象
 */
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer a_id;
	private String a_province;
	private String a_city;
	private String a_street;
	private String a_recv;
	private String a_recvtel;
	private User user;

	public Integer getA_id() {
		return a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	public String getA_province() {
		return a_province;
	}

	public void setA_province(String a_province) {
		this.a_province = a_province;
	}

	public String getA_city() {
		return a_city;
	}

	public void setA_city(String a_city) {
		this.a_city = a_city;
	}

	public String getA_street() {
		return a_street;
	}

	public void setA_street(String a_street) {
		this.a_street = a_street;
	}

	public String getA_recv() {
		return a_recv;
	}

	public void setA_recv(String a_recv) {
		this.a_recv = a_recv;
	}

	public String getA_recvtel() {
		return a_recvtel;
	}

	public void setA_recvtel(String a_recvtel) {
		this.a_recvtel = a_recvtel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
