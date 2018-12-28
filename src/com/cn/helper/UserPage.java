package com.cn.helper;


public class UserPage extends BasePageHelper {

	private String id = null;
	private String name = null;
	
	public UserPage(String id,String name,String page, String limit) {
		super(page, limit);
		this.id = id;
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserPage [id=" + id + ", name=" + name + ", page=" + page + ", limit=" + limit + "]";
	}

	
	

}
