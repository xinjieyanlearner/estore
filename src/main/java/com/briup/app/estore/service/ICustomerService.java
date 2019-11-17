package com.briup.app.estore.service;

import com.briup.app.estore.bean.Customer;

public interface ICustomerService {
	//注册
	void register(Customer customer)throws Exception;
	//根据名字查
	Customer findByName(String name);
//	更改信息
	void upCustomer(Customer customer);
	
}
