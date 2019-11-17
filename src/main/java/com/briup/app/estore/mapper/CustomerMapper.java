package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Customer;
import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);
    //插入
    int insert(Customer record);
    //删除
    Customer selectByPrimaryKey(Integer id);
    //  查询
    List<Customer> selectAll();
    //更新
    int updateByPrimaryKey(Customer record);
    //根据名字查
    Customer findByName(String name);
}