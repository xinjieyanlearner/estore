package com.briup.app.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.mapper.OrderlineMapper;
import com.briup.app.estore.service.ILineService;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class LineService implements ILineService {

	@Override
	public void soveOrderLine(Orderline orderLine) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderlineMapper orderlineMapper = sqlSession.getMapper(OrderlineMapper.class);
		orderlineMapper.insert(orderLine);
		sqlSession.commit();
	}

	@Override
	public void deleFk(Integer fk) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderlineMapper orderlineMapper = sqlSession.getMapper(OrderlineMapper.class);
		orderlineMapper.deleFk(fk);
		sqlSession.commit();
	}
	
}
