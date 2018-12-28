package com.cn.helper;

public class BasePageHelper {
	public Integer page;
	public Integer limit;
	public Integer getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = (Integer.valueOf(page)-1) * this.limit ;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = Integer.valueOf(limit);
	}
	public BasePageHelper(String page, String limit) {
		this.limit = Integer.valueOf(limit);
		this.page = (Integer.valueOf(page)-1) * this.limit ;
	}
	
	
	

}
