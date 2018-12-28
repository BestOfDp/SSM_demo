package com.cn.VO;

public class InsertIntoOrders {
	private Integer oid;
	private String ocode;
	private String merchandisenumber;
	private String orderdata;
	private String customerid;
	private String merchandiseid;
	private String employeeid;
	
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getOcode() {
		return ocode;
	}
	public void setOcode(String ocode) {
		this.ocode = ocode;
	}
	public String getMerchandisenumber() {
		return merchandisenumber;
	}
	public void setMerchandisenumber(String merchandisenumber) {
		this.merchandisenumber = merchandisenumber;
	}
	public String getOrderdata() {
		return orderdata;
	}
	public void setOrderdata(String orderdata) {
		this.orderdata = orderdata;
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
		return "InsertIntoOrders [oid=" + oid + ", ocode=" + ocode + ", merchandisenumber=" + merchandisenumber
				+ ", orderdata=" + orderdata + ", customerid=" + customerid + ", merchandiseid=" + merchandiseid
				+ ", employeeid=" + employeeid + "]";
	}
	

}
