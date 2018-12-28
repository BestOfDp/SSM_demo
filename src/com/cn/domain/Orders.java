package com.cn.domain;

public class Orders {

	private Integer oid;
	private String ocode;
	private String merchandisenumber;
	private String orderdata;
	private Customer customer;
	private Merchandise merchandise;
	private Employee employee;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", ocode=" + ocode + ", merchandisenumber=" + merchandisenumber + ", orderdata="
				+ orderdata + ", customer=" + customer + ", merchandise=" + merchandise + ", employee=" + employee
				+ "]";
	}
	
	
}
