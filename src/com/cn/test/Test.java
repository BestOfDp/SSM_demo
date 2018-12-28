package com.cn.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.domain.User;
import com.cn.service.LoginDao;
import com.cn.service.RegisterDao;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		DataSource dataSource = (DataSource)applicationContext.getBean("dataSource");
//		Connection connection = dataSource.getConnection();
//		ResultSet resultSet = connection.createStatement().executeQuery("select * from user");
//		while(resultSet.next()) {
//			System.out.println(resultSet.getString(2));
//		}
//		LoginDao loginDao = (LoginDao) applicationContext.getBean("userService");
//		User user = new User();
//		user.setUsername("wu");
//		user.setPassword("123");
//		System.out.println(loginDao.checkUser(user));
		
		RegisterDao registerDao = (RegisterDao) applicationContext.getBean("registerUser");
		User user = new User();
		user.setUsername("1ni");
		user.setPassword("qqq");
		user.setUsex("男");
		user.setHobby("11111");
		
		registerDao.insertUser(user);
	}

}
