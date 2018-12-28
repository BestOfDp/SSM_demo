package com.cn.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.domain.User;
import com.cn.helper.UserPage;

@Service("getAllUser")
public class UserDao {

	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;
	
	public void addUser(User user) {
		sqlSessionTemplate.insert("addUser",user);
	}
	public List<User> getAllUser(UserPage userPage) {
		List<User> list = new ArrayList<>();
		list = sqlSessionTemplate.selectList("selectAlluser",userPage);
		return list;
	}
	
	public Integer getCount(User user) {
		return sqlSessionTemplate.selectOne("countUser",user);
	}
	
	public User findUserById(String id) {
		return sqlSessionTemplate.selectOne("findById",id);
	}
	
	public void updateUser(User user) {
		sqlSessionTemplate.update("updateUser",user);
	}
	
	public void deleteUser(String id) {
		sqlSessionTemplate.delete("deleteUser",id);
	}
}
