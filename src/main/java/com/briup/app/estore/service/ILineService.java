package com.briup.app.estore.service;

import com.briup.app.estore.bean.Orderline;

public interface ILineService {
	void soveOrderLine(Orderline orderLine);
	
	void deleFk(Integer fk);
}