package com.cn.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.domain.User;

@Service("registerUser")
public class RegisterDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public boolean insertUser(User user) {
		int result = sqlSessionTemplate.insert("addUser",user);
		if(result==0) {
			return false;
		}else {
			return true;
		}
		
	}
}
