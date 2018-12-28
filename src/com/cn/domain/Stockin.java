package com.cn.domain;

public class Stockin {
	
	private Integer sid;
	private String scode;
	private String amount;
	private String sprice;
	private String stockindate;
	private Customer customer;
	private Employee employee;
	private Merchandise merchandise;
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
	public String getStcokindate() {
		return stockindate;
	}
	public void setStockdata(String stockindate) {
		this.stockindate = stockindate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	@Override
	public String toString() {
		return "Stockin [sid=" + sid + ", scode=" + scode + ", amount=" + amount + ", sprice=" + sprice
				+ ", stockindate=" + stockindate + ", customer=" + customer + ", employee=" + employee
				+ ", merchandise=" + merchandise + "]";
	}
	
	

}
