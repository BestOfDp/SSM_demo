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
import com.cn.VO.InsertIntoStockin;
import com.cn.VO.OrderResultVO;
import com.cn.VO.ResultVO;
import com.cn.VO.StockinResultVO;
import com.cn.domain.Orders;
import com.cn.domain.Stockin;
import com.cn.helper.OrdersHelper;
import com.cn.helper.OrdersPage;
import com.cn.helper.StockinHelper;
import com.cn.helper.StockinPage;
import com.cn.service.StockinDao;
import com.cn.utils.GenCodeUtil;
import com.google.gson.Gson;

@Controller
public class StockinController {

	@Autowired
	private StockinDao stockinDao;
	
	@RequestMapping("getAllStockin.do")
	@ResponseBody
	public String getAllStockin(@RequestParam("code")String code,@RequestParam("name")String name,
			@RequestParam("page")String page,@RequestParam("limit") String limit) throws UnsupportedEncodingException {
		name = new String(name.getBytes("ISO-8859-1"), "utf-8"); 
		StockinPage stockinPage = new StockinPage(code, name, page, limit);
		List<StockinResultVO> list = stockinDao.getAllStockin(stockinPage);
		ResultVO<StockinResultVO> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("查询成功");
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping("getStockinCount.do")
	@ResponseBody
	public String getStockinCount(@RequestParam("code") String code,@RequestParam("name")String name) {
		StockinHelper stockHelper = new StockinHelper();
		stockHelper.setName(name);
		stockHelper.setCode(code);
		
		ResultVO<OrderResultVO> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(stockinDao.getCount(stockHelper));
		resultVO.setMsg("查询成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("addStockin.do")
	@ResponseBody
	public String addStockin(@RequestParam("number")String number,
			@RequestParam("price") String price,
			@RequestParam("stockindata") String stockindata,
			@RequestParam("merchandise") String  merchandise,
			@RequestParam("customer") String customer,
			@RequestParam("employee") String employee) {
		InsertIntoStockin insertIntoStockin = new InsertIntoStockin();
		insertIntoStockin.setScode(GenCodeUtil.GenCode());
		insertIntoStockin.setStockindate(stockindata);
		insertIntoStockin.setAmount(number);
		insertIntoStockin.setMerchandiseid(merchandise);
		insertIntoStockin.setSprice(price);
		insertIntoStockin.setCustomerid(customer);
		insertIntoStockin.setEmployeeid(employee);
		stockinDao.addStockin(insertIntoStockin);
		ResultVO<Stockin> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("添加成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("findStockinByCode.do")
	@ResponseBody
	public String findStockinByCode(@RequestParam("id") String id) {
		StockinResultVO stockinResultVO = stockinDao.findStockinById(id);
		ResultVO<StockinResultVO> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("查询成功");
		List<StockinResultVO> list = new ArrayList<>();
		list.add(stockinResultVO);
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("updateStockin.do")
	@ResponseBody
	public String updateStockin(@RequestParam("number")String number,
			@RequestParam("price") String price,
			@RequestParam("stockindata") String stockindata,
			@RequestParam("merchandise") String  merchandise,
			@RequestParam("customer") String customer,
			@RequestParam("employee") String employee,
			@RequestParam("id") String id,
			@RequestParam("code") String code) {
		InsertIntoStockin insertIntoStockin = new InsertIntoStockin();
		insertIntoStockin.setSid(Integer.valueOf(id));
		insertIntoStockin.setScode(code);
		insertIntoStockin.setAmount(number);
		insertIntoStockin.setStockindate(stockindata);
		insertIntoStockin.setMerchandiseid(merchandise);
		insertIntoStockin.setSprice(price);
		insertIntoStockin.setCustomerid(customer);
		insertIntoStockin.setEmployeeid(employee);
		stockinDao.updateStockin(insertIntoStockin);
		ResultVO<Stockin> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("修改成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("deleteStockin.do")
	@ResponseBody
	public String deleteStockin(@RequestParam("id") String id) {
		stockinDao.deleteStockin(id);
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
