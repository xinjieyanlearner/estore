package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Orderline;
import java.util.List;

public interface OrderlineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderline record);

    Orderline selectByPrimaryKey(Integer id);

    List<Orderline> selectAll();

    int updateByPrimaryKey(Orderline record);
    
    void deleFk(Integer id);
}