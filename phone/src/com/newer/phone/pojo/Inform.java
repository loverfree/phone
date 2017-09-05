package com.newer.phone.pojo;

import java.io.Serializable;

public class Inform implements Serializable{
	private static final long serialVersionUID = 2795861076980124102L;
	private Integer o_id;
	private Integer o_status;
	private Integer u_id;
	public Integer getO_id() {
		return o_id;
	}
	public void setO_id(Integer o_id) {
		this.o_id = o_id;
	}
	public Integer getO_status() {
		return o_status;
	}
	public void setO_status(Integer o_status) {
		this.o_status = o_status;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	};
	
	
}
