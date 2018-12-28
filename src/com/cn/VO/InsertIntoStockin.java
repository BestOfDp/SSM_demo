package com.cn.VO;

public class InsertIntoStockin {
	private Integer sid;
	private String scode;
	private String amount;
	private String sprice;
	private String stockindate;
	private String customerid;
	private String merchandiseid;
	private String employeeid;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSprice() {
		return sprice;
	}
	public void setSprice(String sprice) {
		this.sprice = sprice;
	}
	public String getStockindate() {
		return stockindate;
	}
	public void setStockindate(String stockindate) {
		this.stockindate = stockindate;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getMerchandiseid() {
		return merchandiseid;
	}
	public void setMerchandiseid(String merchandiseid) {
		this.merchandiseid = merchandiseid;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	@Override
	public String toString() {
		return "InsertIntoStockin [sid=" + sid + ", scode=" + scode + ", amount=" + amount + ", sprice=" + sprice
				+ ", stockindate=" + stockindate + ", customerid=" + customerid + ", merchandiseid=" + merchandiseid
				+ ", employeeid=" + employeeid + "]";
	}
	
	
}
