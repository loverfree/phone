package com.newer.phone.util;

public enum OstatuEnum {

	NOTPAY(0,"未付款"),
	PAYOK(1,"未发货"),
	SHIPOK(2,"已发货"),
	SUCCEED(3,"交易成功");
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private OstatuEnum(int id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public OstatuEnum getStatuById(int id){
		for (OstatuEnum statu : OstatuEnum.values()) {
			if(statu.getId() == id){
				return statu;
			}
		}
		return null;
	}
	
}
