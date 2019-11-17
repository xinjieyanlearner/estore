package com.briup.app.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class CustomerService implements com.briup.app.estore.service.ICustomerService{

	@Override
	public void register(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		//调用dao层
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		customerMapper.insert(customer);
		sqlSession.commit();
	}

	@Override
	public Customer findByName(String name) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = customerMapper.findByName(name);
		return customer;
	}

	@Override
	public void upCustomer(Customer customer) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		customerMapper.updateByPrimaryKey(customer);
	}

}
