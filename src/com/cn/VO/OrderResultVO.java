package com.cn.VO;

public class OrderResultVO {
	private Integer oid;
	private String ocode;
	private String orderdata;
	private Integer merchandise_id;
	private String merchandise_name;
	private String merchandise_number;
	private Integer customer_id;
	private String customer_name;
	private Integer employee_id;
	private String employee_name;
	
	
	public String getOrderdata() {
		return orderdata;
	}
	public void setOrderdata(String orderadata) {
		this.orderdata = orderadata;
	}
	public String getOcode() {
		return ocode;
	}
	public void setOcode(String ocode) {
		this.ocode = ocode;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getMerchandise_id() {
		return merchandise_id;
	}
	public void setMerchandise_id(Integer merchandise_id) {
		this.merchandise_id = merchandise_id;
	}
	public String getMerchandise_name() {
		return merchandise_name;
	}
	public void setMerchandise_name(String merchandise_name) {
		this.merchandise_name = merchandise_name;
	}
	public String getMerchandise_number() {
		return merchandise_number;
	}
	public void setMerchandise_number(String merchandise_number) {
		this.merchandise_number = merchandise_number;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	@Override
	public String toString() {
		return "OrderResultVO [oid=" + oid + ", ocode=" + ocode + ", orderdata=" + orderdata + ", merchandise_id="
				+ merchandise_id + ", merchandise_name=" + merchandise_name + ", merchandise_number="
				+ merchandise_number + ", customer_id=" + customer_id + ", customer_name=" + customer_name
				+ ", employee_id=" + employee_id + ", employee_name=" + employee_name + "]";
	}
	
}
