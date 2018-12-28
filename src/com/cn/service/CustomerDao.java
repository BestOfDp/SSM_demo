package com.cn.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.domain.Customer;
import com.cn.helper.CustomerPage;
@Service
public class CustomerDao {
	
	@Autowired 
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void addCustomer(Customer customer) {
		sqlSessionTemplate.insert("addCustomer",customer);
	}
	public List<Customer> getAllCustomer(CustomerPage customerPage) {
		List<Customer> list = new ArrayList<>();
		list = sqlSessionTemplate.selectList("selectAllCustomer",customerPage);
		return list;
	}
	
	public Integer getCount(Customer customer) {
		return sqlSessionTemplate.selectOne("countCustomer",customer);
	}
	
	public Customer findCustomerById(String id) {
		return sqlSessionTemplate.selectOne("findCustomerById",id);
	}
	
	public void updateCustomer(Customer customer) {
		sqlSessionTemplate.update("updateCustomer",customer);
	}
	
	public void deleteCustomer(String id) {
		sqlSessionTemplate.delete("deleteCustomer",id);
	}

}
