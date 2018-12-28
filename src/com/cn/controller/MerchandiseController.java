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
import com.cn.domain.Merchandise;
import com.cn.helper.MerchandisePage;
import com.cn.service.MerchandiseDao;
import com.cn.utils.GenCodeUtil;
import com.google.gson.Gson;

@Controller
public class MerchandiseController {

	@Autowired
	private MerchandiseDao merchandiseDao;
	
	@RequestMapping("getAllMerchandise.do")
	@ResponseBody
	public String getAllMerchandise(@RequestParam("code")String code,@RequestParam("name")String name,
			@RequestParam("page")String page,@RequestParam("limit") String limit) throws UnsupportedEncodingException {
		name = new String(name.getBytes("ISO-8859-1"), "utf-8"); 
		MerchandisePage merchandisePage = new MerchandisePage(code, name, page, limit);
		List<Merchandise> list = merchandiseDao.getAllMerchandise(merchandisePage);
		ResultVO<Merchandise> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("查询成功");
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping("getMerchandiseCount.do")
	@ResponseBody
	public String getMerchandiseCount(@RequestParam("code") String code,@RequestParam("name")String name) {
		Merchandise merchandise = new Merchandise();
		merchandise.setMcode(code);
		merchandise.setMname(name);
		
		ResultVO<Merchandise> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(merchandiseDao.getCount(merchandise));
		resultVO.setMsg("查询成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("addMerchandise.do")
	@ResponseBody
	public String addMerchandise(@RequestParam("mname")String mname
			,@RequestParam("mprice") String mprice) {
		Merchandise merchandise = new Merchandise();
		merchandise.setMname(mname);
		merchandise.setMprice(mprice);
		merchandise.setMcode(GenCodeUtil.GenCode());
		merchandiseDao.addProduct(merchandise);
		ResultVO<Merchandise> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("添加成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("findMerchandiseByid.do")
	@ResponseBody
	public String findMerchandiseByid(@RequestParam("id") String id) {
		Merchandise merchandise = merchandiseDao.findMerchandiseById(id);
		ResultVO<Merchandise> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("查询成功");
		List<Merchandise> list = new ArrayList<>();
		list.add(merchandise);
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("updateMerchandise.do")
	@ResponseBody
	public String updateMerchandise(@RequestParam("mcode")String mcode,@RequestParam("mname")String mname
			,@RequestParam("mprice") String mprice,@RequestParam("mid") String id) {
		Merchandise merchandise = new Merchandise();
		merchandise.setMid(Integer.valueOf(id));
		merchandise.setMcode(mcode);
		merchandise.setMname(mname);
		merchandise.setMprice(mprice);
		System.out.println(merchandise);
		merchandiseDao.updateMerchandise(merchandise);
		ResultVO<Merchandise> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("修改成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("deleteMerchandise.do")
	@ResponseBody
	public String deleteMerchandise(@RequestParam("id") String id) {
		merchandiseDao.deleteMerchandise(id);
		ResultVO<Merchandise> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("删除成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
}
