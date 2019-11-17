package com.briup.app.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Order;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.mapper.OrderMapper;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class OrderService implements IOrderService {
	
	@Override
	public void saveOrder(Order order) {
		//保存订单信息
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		orderMapper.insert(order);
		sqlSession.commit();
	}

	@Override
	public Order findById(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		Order order = orderMapper.selectByPrimaryKey(id);
		return order;
	}

	@Override
	public void deleteOrder(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		orderMapper.deleteByPrimaryKey(id);
		sqlSession.commit();
		
	}
	
	

}
