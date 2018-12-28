package com.cn.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.domain.User;

@Service("userService")
public class LoginDao {

	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;
	
	public User checkUser(User user) {
		User user1 = sqlSessionTemplate.selectOne("selectuser",user);
		return user1;
	}
}
