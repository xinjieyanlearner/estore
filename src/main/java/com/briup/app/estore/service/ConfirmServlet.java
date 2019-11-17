package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.ILineService;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.impl.CustomerService;
import com.briup.app.estore.service.impl.LineService;
import com.briup.app.estore.service.impl.OrderService;
import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {
	private IOrderService orderService = new OrderService();
    private ILineService lineService = new LineService();
    private List<Order> orders = new ArrayList();
    private ICustomerService customerService = new CustomerService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart shoppingCart =(ShoppingCart) request.getSession().getAttribute("shoppingCart");
		double cost = shoppingCart.getCost();
		Customer Fcustomer =(Customer) request.getSession().getAttribute("Fcustomer");
		Integer customerId =  Fcustomer.getId();
		
		
		 
		 Order order = new Order();
		 order.setCost(cost);
		 order.setCustomer(Fcustomer);
		 
		 request.getSession().setAttribute("Fcustomer", Fcustomer);
		 order.setOrderdate(new Date());
		 orders.add(order);
		 Fcustomer.setOrders(orders);
		 orderService.saveOrder(order);
		 //订单明细
		 
		 Map<Integer, Orderline> lines = shoppingCart.getLines();
		 for(Integer key:lines.keySet()) {
			 Integer bookId=key;
			 Orderline orderline = lines.get(key);
			 orderline.setOrder(order);
			 lineService.soveOrderLine(orderline);
			 //book   order
			 //bookid orderid
		 }
		 //更新用户信息
		 String tid = request.getParameter("tid");
		 if("1".equals(tid)) {
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String zip = request.getParameter("zip");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		Fcustomer.setPassword(password);
		Fcustomer.setAddress(address);
		Fcustomer.setZip(zip);
		Fcustomer.setTelephone(telephone);
		Fcustomer.setEmail(email);
		//往数据库保存更改后的用户信息
		customerService.upCustomer(Fcustomer);
		request.getSession().setAttribute("Fcustomer", Fcustomer);
		System.out.println("更新后"+password);
		System.out.println("更新后"+address);
		System.out.println("更新后"+zip);
		System.out.println("更新后"+telephone);
		System.out.println("更新后"+email);
		 }
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		//更新订单信息是会跳转到购物车页面
		
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
