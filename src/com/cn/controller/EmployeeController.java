package com.cn.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.VO.ResultVO;
import com.cn.domain.Customer;
import com.cn.domain.Employee;
import com.cn.domain.Merchandise;
import com.cn.helper.CustomerPage;
import com.cn.helper.EmployeePage;
import com.cn.service.EmployeeDao;
import com.cn.utils.GenCodeUtil;
import com.google.gson.Gson;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping("getAllEmployee.do")
	@ResponseBody
	public String getAllEmployee(@RequestParam("code")String code,@RequestParam("name")String name,
			@RequestParam("page")String page,@RequestParam("limit") String limit) throws UnsupportedEncodingException {
		name = new String(name.getBytes("ISO-8859-1"), "utf-8"); 
		EmployeePage employeePage = new EmployeePage(code, name, page, limit);
		List<Employee> list = employeeDao.getAllEmployee(employeePage);
		ResultVO<Employee> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("查询成功");
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping("getEmployeeCount.do")
	@ResponseBody
	public String getEmployeeCount(@RequestParam("code") String code,@RequestParam("name")String name) {
		Employee employee = new Employee();
		employee.setEcode(code);
		employee.setEname(name);
		
		ResultVO<Merchandise> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(employeeDao.getCount(employee));
		resultVO.setMsg("查询成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("addEmployee.do")
	@ResponseBody
	public String addEmployee(@RequestParam("ename")String ename,@RequestParam("birthday") String birthday,
			@RequestParam("sex") String  sex,@RequestParam("etelephone") String etelephone,
			@RequestParam("eemail") String eemail) {
		Employee employee = new Employee();
		employee.setEcode(GenCodeUtil.GenCode());
		employee.setEname(ename);
		employee.setBirthday(birthday);
		employee.setSex(sex);
		employee.setEtelephone(etelephone);
		employee.setEemail(eemail);
		employeeDao.addEmployee(employee);
		ResultVO<Employee> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("添加成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("findEmployeeByid.do")
	@ResponseBody
	public String findEmployeeByid(@RequestParam("id") String id) {
		Employee employee = employeeDao.findEmployeeById(id);
		ResultVO<Employee> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("查询成功");
		List<Employee> list = new ArrayList<>();
		list.add(employee);
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("updateEmployee.do")
	@ResponseBody
	public String updateEmployee(@RequestParam("ename")String ename,@RequestParam("birthday") String birthday,
			@RequestParam("sex") String  sex,@RequestParam("etelephone") String etelephone,
			@RequestParam("eemail") String eemail,@RequestParam("eid") String eid,
			@RequestParam("ecode")String ecode) {
		Employee employee = new Employee();
		employee.setEid(Integer.valueOf(eid));
		employee.setEcode(ecode);
		employee.setEname(ename);
		employee.setBirthday(birthday);
		employee.setSex(sex);
		employee.setEtelephone(etelephone);
		employee.setEemail(eemail);
		employeeDao.updateEmployee(employee);
		ResultVO<Employee> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("修改成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("deleteEmployee.do")
	@ResponseBody
	public String deleteEmployee(@RequestParam("id") String id) {
		employeeDao.deleteEmployee(id);
		ResultVO<Employee> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("删除成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
}
