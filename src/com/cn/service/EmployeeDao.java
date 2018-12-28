package com.cn.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.domain.Employee;
import com.cn.helper.EmployeePage;

@Service
public class EmployeeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void addEmployee(Employee employee) {
		sqlSessionTemplate.insert("addEmployee",employee);
	}
	public List<Employee> getAllEmployee(EmployeePage employeePage) {
		List<Employee> list = new ArrayList<>();
		list = sqlSessionTemplate.selectList("selectAllEmployee",employeePage);
		return list;
	}
	
	public Integer getCount(Employee employee) {
		return sqlSessionTemplate.selectOne("countEmployee",employee);
	}
	
	public Employee findEmployeeById(String id) {
		return sqlSessionTemplate.selectOne("findEmployeeById",id);
	}
	
	public void updateEmployee(Employee employee) {
		sqlSessionTemplate.update("updateEmployee",employee);
	}
	
	public void deleteEmployee(String id) {
		sqlSessionTemplate.delete("deleteEmployee",id);
	}

}
