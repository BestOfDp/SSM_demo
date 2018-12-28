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
import com.cn.domain.Merchandise;
import com.cn.helper.CustomerPage;
import com.cn.helper.MerchandisePage;
import com.cn.service.CustomerDao;
import com.cn.utils.GenCodeUtil;
import com.google.gson.Gson;
import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

@Controller
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("getAllCustomer.do")
	@ResponseBody
	public String getAllCustomer(@RequestParam("code")String code,@RequestParam("name")String name,
			@RequestParam("page")String page,@RequestParam("limit") String limit) throws UnsupportedEncodingException {
		name = new String(name.getBytes("ISO-8859-1"), "utf-8"); 
		CustomerPage customerPage = new CustomerPage(code, name, page, limit);
		List<Customer> list = customerDao.getAllCustomer(customerPage);
		ResultVO<Customer> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("查询成功");
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping("getCustomerCount.do")
	@ResponseBody
	public String getCustomerCount(@RequestParam("code") String code,@RequestParam("name")String name) {
		Customer customer = new Customer();
		customer.setCcode(code);
		customer.setCname(name);
		
		ResultVO<Merchandise> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(customerDao.getCount(customer));
		resultVO.setMsg("查询成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("addCustomer.do")
	@ResponseBody
	public String addCustomer(@RequestParam("cname")String cname,@RequestParam("address") String address,
			@RequestParam("tel") String  tel,@RequestParam("cemail") String cemail) {
		Customer customer = new Customer();
		customer.setCcode(GenCodeUtil.GenCode());
		customer.setCname(cname);
		customer.setAddress(address);
		customer.setCtelephone(tel);
		customer.setCemail(cemail);
		customerDao.addCustomer(customer);
		ResultVO<Customer> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("添加成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("findCustomerByid.do")
	@ResponseBody
	public String findCustomerByid(@RequestParam("id") String id) {
		Customer customer = customerDao.findCustomerById(id);
		ResultVO<Customer> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("查询成功");
		List<Customer> list = new ArrayList<>();
		list.add(customer);
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("updateCustomer.do")
	@ResponseBody
	public String updateCustomer(@RequestParam("cname")String cname,@RequestParam("address") String address,
			@RequestParam("tel") String  tel,@RequestParam("cemail") String cemail,
			@RequestParam("cid")String cid,@RequestParam("ccode") String ccode) {
		Customer customer = new Customer();
		customer.setCid(Integer.valueOf(cid));
		customer.setCcode(ccode);
		customer.setCname(cname);
		customer.setAddress(address);
		customer.setCtelephone(tel);
		customer.setCemail(cemail);
		customerDao.updateCustomer(customer);
		ResultVO<Customer> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("修改成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("deleteCustomer.do")
	@ResponseBody
	public String deleteCustomer(@RequestParam("id") String id) {
		customerDao.deleteCustomer(id);
		ResultVO<Customer> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("删除成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	

}
