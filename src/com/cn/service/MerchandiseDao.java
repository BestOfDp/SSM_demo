package com.cn.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.domain.Merchandise;
import com.cn.helper.MerchandisePage;

@Service("product")
public class MerchandiseDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void addProduct(Merchandise merchandise) {
		sqlSessionTemplate.insert("addMerchandise",merchandise);
	}
	
	public List<Merchandise> getAllMerchandise(MerchandisePage merchandisePage){
		return sqlSessionTemplate.selectList("selectAllMerchandise",merchandisePage);
	}
	
	public Integer getCount(Merchandise merchandise) {
		return sqlSessionTemplate.selectOne("countMerchandise",merchandise);
	}
	
	public Merchandise findMerchandiseById(String id) {
		return sqlSessionTemplate.selectOne("findByMerchandiseId",id);
	}
	
	public void updateMerchandise(Merchandise merchandise) {
		sqlSessionTemplate.update("updateMerchandise",merchandise);
	}
	
	public void deleteMerchandise(String id) {
		sqlSessionTemplate.delete("deleteMerchandise",id);
	}
}
