package com.cn.helper;

public class StockinPage extends BasePageHelper{
	private String code;
	private String name;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public StockinPage(String code,String name,String page, String limit) {
		super(page, limit);
		this.code = code;
		this.name = name;
	}
}
