package com.cn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.VO.ResultVO;
import com.cn.domain.User;
import com.cn.service.LoginDao;
import com.google.gson.Gson;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

@Controller
public class LoginController {

	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping("loginsuccess.do")
	public String checkUser(User user,Model model) {
		System.out.println(user);
		User user2 = loginDao.checkUser(user);
		model.addAttribute("u",user2);
		if(user2!=null) {
			return "main";
		}else {
			return "fail";
		}
//		return null;
	} 
	
	@RequestMapping(value = "login.do")
	@ResponseBody
	public String login(@RequestParam("name") String name,@RequestParam("password") String password,HttpSession httpSession) {
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		User result = loginDao.checkUser(user);
		ResultVO<User> resultVO = new ResultVO<>();
		if(result!=null) {
			resultVO.setCode(0);
			List<User>list = new ArrayList<>();
			list.add(result);
			resultVO.setData(list);
			httpSession.setAttribute("user",  result);
		}else{
			resultVO.setCode(1);
			resultVO.setMsg("用户名或密码错误");
		}
		Gson gson = new Gson();
		String json = gson.toJson(resultVO);
		System.out.println(json);
		return json;
	}
}
