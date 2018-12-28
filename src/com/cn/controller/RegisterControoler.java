package com.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.domain.User;
import com.cn.service.RegisterDao;

@Controller
public class RegisterControoler {

	@Autowired
	private RegisterDao registerDao;
	
	@RequestMapping("registersuccess.do")
	public String register(User user) {
		boolean result = registerDao.insertUser(user);
		if(result) {
			return "registersuccess";
		}else {
			return null;
		}
	}
	
	@RequestMapping("register.do")
	public String goregister() {
		return "register";
	}
}
