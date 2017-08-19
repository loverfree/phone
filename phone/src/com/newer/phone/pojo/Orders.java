package com.newer.phone.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author samluby E-mail:yang_960107@sina.com
 * @version 2017��8��19�� ����3:37:32
 * 
 * �������ʵ�������--ORDERS
 * o_id:����id
 * o_total:�����ܼ�
 * a_province:�ջ���ַʡ��
 * a_city:�ջ���ַ����
 * a_street:�ջ���ַ�ֵ���ϸ��Ϣ
 * a_recv:�ջ�������
 * a_recvtel:�ջ����ֻ�����
 * o_time:��������ʱ�䣬ϵͳĬ��ʱ��
 * user:����ӵ�е��û�����
 * p_o:������product��������
 */
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer o_id;
	private BigDecimal o_total;
	private String a_province;
	private String a_city;
	private String a_street;
	private String a_recv;
	private String a_recvtel;
	private Integer o_status;
	private Date o_time;
	private User user;
	private List<P_O> p_os;

	public Integer getO_id() {
		return o_id;
	}

	public void setO_id(Integer o_id) {
		this.o_id = o_id;
	}

	public BigDecimal getO_total() {
		return o_total;
	}

	public void setO_total(BigDecimal o_total) {
		this.o_total = o_total;
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

	public Integer getO_status() {
		return o_status;
	}

	public void setO_status(Integer o_status) {
		this.o_status = o_status;
	}

	public Date getO_time() {
		return o_time;
	}

	public void setO_time(Date o_time) {
		this.o_time = o_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<P_O> getP_os() {
		return p_os;
	}

	public void setP_o(List<P_O> p_os) {
		this.p_os = p_os;
	}
	
	

}
