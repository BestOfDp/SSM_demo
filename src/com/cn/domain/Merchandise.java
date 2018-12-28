package com.cn.domain;

public class Merchandise {
	
	private Integer mid;
	private String mcode;
	private String mname;
	private String mprice;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMprice() {
		return mprice;
	}
	public void setMprice(String mprice) {
		this.mprice = mprice;
	}
	@Override
	public String toString() {
		return "Merchandise [mid=" + mid + ", mcode=" + mcode + ", mname=" + mname + ", mprice=" + mprice + "]";
	}
	
	

}
