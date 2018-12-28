package com.cn.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.VO.InsertIntoOrders;
import com.cn.VO.OrderResultVO;
import com.cn.VO.ResultVO;
import com.cn.domain.Customer;
import com.cn.domain.Merchandise;
import com.cn.domain.Orders;
import com.cn.helper.CustomerPage;
import com.cn.helper.OrdersHelper;
import com.cn.helper.OrdersPage;
import com.cn.service.OrdersDao;
import com.cn.utils.GenCodeUtil;
import com.google.gson.Gson;

@Controller
public class OrdersController {
	@Autowired
	private OrdersDao ordersDao;
	
	@RequestMapping("getAllOrders.do")
	@ResponseBody
	public String getAllOrders(@RequestParam("code")String code,@RequestParam("name")String name,
			@RequestParam("page")String page,@RequestParam("limit") String limit) throws UnsupportedEncodingException {
		name = new String(name.getBytes("ISO-8859-1"), "utf-8"); 
		OrdersPage ordersPage = new OrdersPage(code, name, page, limit);
		List<OrderResultVO> list = ordersDao.getAllOrders(ordersPage);
		ResultVO<OrderResultVO> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("查询成功");
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping("getOrdersCount.do")
	@ResponseBody
	public String getCount(@RequestParam("code") String code,@RequestParam("name")String name) {
		OrdersHelper orders = new OrdersHelper();
		orders.setName(name);
		orders.setCode(code);
		
		ResultVO<OrderResultVO> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(ordersDao.getCount(orders));
		resultVO.setMsg("查询成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("addOrders.do")
	@ResponseBody
	public String addOrders(@RequestParam("number")String number,
			@RequestParam("orderdata") String orderdata,
			@RequestParam("merchandise") String  merchandise,
			@RequestParam("customer") String customer,
			@RequestParam("employee") String employee) {
		InsertIntoOrders insertIntoOrders = new InsertIntoOrders();
		insertIntoOrders.setOcode(GenCodeUtil.GenCode());
		insertIntoOrders.setOrderdata(orderdata);
		insertIntoOrders.setMerchandiseid(merchandise);
		insertIntoOrders.setMerchandisenumber(number);
		insertIntoOrders.setCustomerid(customer);
		insertIntoOrders.setEmployeeid(employee);
		ordersDao.addOrders(insertIntoOrders);
		ResultVO<Orders> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("添加成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("findOrdersByCode.do")
	@ResponseBody
	public String findOrdersByCode(@RequestParam("id") String id) {
		OrderResultVO orderResultVO = ordersDao.findOrdersById(id);
		ResultVO<OrderResultVO> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("查询成功");
		List<OrderResultVO> list = new ArrayList<>();
		list.add(orderResultVO);
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("updateOrders.do")
	@ResponseBody
	public String updateOrders(@RequestParam("number")String number,
			@RequestParam("orderdata") String orderdata,
			@RequestParam("merchandise") String  merchandise,
			@RequestParam("customer") String customer,
			@RequestParam("employee") String employee,
			@RequestParam("id") String id,
			@RequestParam("code") String code) {
		InsertIntoOrders insertIntoOrders = new InsertIntoOrders();
		insertIntoOrders.setOid(Integer.valueOf(id));
		insertIntoOrders.setOcode(code);
		insertIntoOrders.setOrderdata(orderdata);
		insertIntoOrders.setMerchandiseid(merchandise);
		insertIntoOrders.setMerchandisenumber(number);
		insertIntoOrders.setCustomerid(customer);
		insertIntoOrders.setEmployeeid(employee);
		ordersDao.updateOrders(insertIntoOrders);
		ResultVO<Orders> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("修改成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("deleteOrders.do")
	@ResponseBody
	public String deleteOrders(@RequestParam("id") String id) {
		ordersDao.deleteOrders(id);
		ResultVO<Orders> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("删除成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}


}
