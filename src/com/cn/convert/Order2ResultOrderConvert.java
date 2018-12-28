package com.cn.convert;

import java.util.ArrayList;
import java.util.List;

import com.cn.VO.OrderResultVO;
import com.cn.domain.Orders;

public class Order2ResultOrderConvert {

	public static OrderResultVO turnOne(Orders orders) {
		OrderResultVO orderResultVO = new OrderResultVO();
		orderResultVO.setOid(orders.getOid());
		orderResultVO.setMerchandise_id(orders.getMerchandise().getMid());
		orderResultVO.setMerchandise_name(orders.getMerchandise().getMname());
		orderResultVO.setMerchandise_number(orders.getMerchandisenumber());
		orderResultVO.setCustomer_id(orders.getCustomer().getCid());
		orderResultVO.setCustomer_name(orders.getCustomer().getCname());
		orderResultVO.setEmployee_id(orders.getEmployee().getEid());
		orderResultVO.setEmployee_name(orders.getEmployee().getEname());
		orderResultVO.setOcode(orders.getOcode());
		orderResultVO.setOrderdata(orders.getOrderdata());
		return orderResultVO;
	}
	
	public static List<OrderResultVO> turnOne(List<Orders>list){
		List<OrderResultVO>list2 = new ArrayList<>();
		for(Orders orders:list) {
			list2.add(turnOne(orders));
		}
		return list2;
	}
}
