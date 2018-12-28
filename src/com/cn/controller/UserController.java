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
import com.cn.domain.User;
import com.cn.helper.BasePageHelper;
import com.cn.helper.UserPage;
import com.cn.service.UserDao;
import com.google.gson.Gson;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;

	@RequestMapping("getAllUser.do")
	@ResponseBody
	public String getAllUser(@RequestParam("id")String id,@RequestParam("name")String name,
				@RequestParam("page")String page,@RequestParam("limit") String limit) throws UnsupportedEncodingException {
		name = new String(name.getBytes("ISO-8859-1"), "utf-8"); 
		UserPage userPage = new UserPage(id,name,page, limit);
		List<User> list = userDao.getAllUser(userPage);
		ResultVO<User> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setMsg("查询成功");
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		System.out.println(json);
		return json;
	}
	
	
	@RequestMapping("getUserCount.do")
	@ResponseBody
	public String getCount(@RequestParam("id") String id,@RequestParam("name")String name) {
		User user = new User();
		user.setId(id);
		user.setUsername(name);
		ResultVO<User> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(userDao.getCount(user));
		resultVO.setMsg("查询成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("addUser.do")
	@ResponseBody
	public String addUser(@RequestParam("username")String username,@RequestParam("usex")String usex
			,@RequestParam("hobby") String hobby,@RequestParam("password")String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setUsex(usex);
		user.setHobby(hobby);
		userDao.addUser(user);
		ResultVO<User> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("添加成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("findUserByid.do")
	@ResponseBody
	public String findUserByid(@RequestParam("id") String id) {
		User user = userDao.findUserById(id);
		ResultVO<User> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("查询成功");
		List<User> list = new ArrayList<>();
		list.add(user);
		resultVO.setData(list);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("updateUser.do")
	@ResponseBody
	public String updateUser(@RequestParam("username")String username,@RequestParam("usex")String usex
			,@RequestParam("hobby") String hobby,@RequestParam("password")String password,
			@RequestParam("id") String id) {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setUsex(usex);
		user.setPassword(password);
		user.setHobby(hobby);
		System.out.println(user);
		userDao.updateUser(user);
		ResultVO<User> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(1);
		resultVO.setMsg("修改成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
	
	@RequestMapping("deleteUser.do")
	@ResponseBody
	public String deleteUser(@RequestParam("id") String id) {
		userDao.deleteUser(id);
		ResultVO<User> resultVO = new ResultVO<>();
		resultVO.setCode(0);
		resultVO.setCount(0);
		resultVO.setMsg("删除成功");
		resultVO.setData(null);
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		return json;
	}
}
