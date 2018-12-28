package com.cn.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.VO.InsertIntoOrders;
import com.cn.VO.InsertIntoStockin;
import com.cn.VO.OrderResultVO;
import com.cn.VO.StockinResultVO;
import com.cn.convert.Order2ResultOrderConvert;
import com.cn.convert.Stockin2ResultStockinConvert;
import com.cn.domain.Orders;
import com.cn.domain.Stockin;
import com.cn.helper.OrdersHelper;
import com.cn.helper.StockinHelper;
import com.cn.helper.StockinPage;

@Service
public class StockinDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<StockinResultVO> getAllStockin(StockinPage stockinPage){
		return Stockin2ResultStockinConvert.
				turnOne(sqlSessionTemplate.selectList("selectAllStockin",stockinPage));
	}
	
	public Integer getCount(StockinHelper stockHelper) {
		return sqlSessionTemplate.selectOne("countStockin",stockHelper);
	}
	
	public void addStockin(InsertIntoStockin insertIntoStockin) {
		sqlSessionTemplate.insert("addStockin",insertIntoStockin);
	}
	
	public StockinResultVO findStockinById(String code) {
		Stockin stockin = sqlSessionTemplate.selectOne("findStockinByCode",code);
		return Stockin2ResultStockinConvert.turnOne(stockin);
	}
	
	public void updateStockin(InsertIntoStockin insertIntoStockin) {
		sqlSessionTemplate.update("updateStockin",insertIntoStockin);
	}
	
	public void deleteStockin(String id) {
		sqlSessionTemplate.delete("deleteStockin",id);
	}
}
