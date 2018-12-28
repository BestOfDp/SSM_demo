package com.cn.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.VO.InsertIntoOrders;
import com.cn.VO.OrderResultVO;
import com.cn.convert.Order2ResultOrderConvert;
import com.cn.domain.Customer;
import com.cn.domain.Orders;
import com.cn.helper.OrdersHelper;
import com.cn.helper.OrdersPage;

@Service
public class OrdersDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<OrderResultVO> getAllOrders(OrdersPage ordersPage){
		return Order2ResultOrderConvert.
				turnOne(sqlSessionTemplate.selectList("selectAllOrders",ordersPage));
	}
	
	public Integer getCount(OrdersHelper orders) {
		return sqlSessionTemplate.selectOne("countOrders",orders);
	}
	
	public void addOrders(InsertIntoOrders insertIntoOrders) {
		sqlSessionTemplate.insert("addOrders",insertIntoOrders);
	}
	
	public OrderResultVO findOrdersById(String code) {
		Orders orders = sqlSessionTemplate.selectOne("findOrdersByCode",code);
		return Order2ResultOrderConvert.turnOne(orders);
	}
	
	public void updateOrders(InsertIntoOrders insertIntoOrders) {
		sqlSessionTemplate.update("updateOrders",insertIntoOrders);
	}
	
	public void deleteOrders(String id) {
		sqlSessionTemplate.delete("deleteOrders",id);
	}
}
