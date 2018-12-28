package com.cn.domain;

public class Employee {
	private Integer eid;
	private String ecode;
	private String ename;
	private String birthday;
	private String sex;
	private String etelephone;
	private String eemail;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEtelephone() {
		return etelephone;
	}
	public void setEtelephone(String etelephone) {
		this.etelephone = etelephone;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ecode=" + ecode + ", ename=" + ename + ", birthday=" + birthday + ", sex="
				+ sex + ", etelephone=" + etelephone + ", eemail=" + eemail + "]";
	}
	
	
}
