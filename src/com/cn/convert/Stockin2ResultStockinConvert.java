package com.cn.convert;

import java.util.ArrayList;
import java.util.List;

import com.cn.VO.OrderResultVO;
import com.cn.VO.StockinResultVO;
import com.cn.domain.Orders;
import com.cn.domain.Stockin;

public class Stockin2ResultStockinConvert {
	public static StockinResultVO turnOne(Stockin stockin) {
		StockinResultVO stockinResultVO = new StockinResultVO();
		stockinResultVO.setSid(stockin.getSid());
		stockinResultVO.setScode(stockin.getScode());
		stockinResultVO.setAmount(stockin.getAmount());
		stockinResultVO.setSprice(stockin.getSprice());
		stockinResultVO.setStockindata(stockin.getStcokindate());
		stockinResultVO.setMerchandise_id(stockin.getMerchandise().getMid());
		stockinResultVO.setMerchandise_name(stockin.getMerchandise().getMname());
		stockinResultVO.setCustomer_id(stockin.getCustomer().getCid());
		stockinResultVO.setCustomer_name(stockin.getCustomer().getCname());
		stockinResultVO.setEmployee_id(stockin.getEmployee().getEid());
		stockinResultVO.setEmployee_name(stockin.getEmployee().getEname());
		return stockinResultVO;
	}
	
	public static List<StockinResultVO> turnOne(List<Stockin>list){
		List<StockinResultVO>list2 = new ArrayList<>();
		for(Stockin stockin:list) {
			list2.add(turnOne(stockin));
		}
		return list2;
	}
}
