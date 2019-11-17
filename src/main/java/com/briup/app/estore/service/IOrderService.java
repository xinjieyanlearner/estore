package com.briup.app.estore.service;

import com.briup.app.estore.bean.Order;

public interface IOrderService {
	void saveOrder(Order order);
	//查询订单
	Order findById(Integer id);
	//删除订单
	void deleteOrder(Integer id);
}
