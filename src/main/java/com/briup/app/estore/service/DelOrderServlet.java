package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.service.ILineService;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.impl.LineService;
import com.briup.app.estore.service.impl.OrderService;


@WebServlet("/delOrder")
public class DelOrderServlet extends HttpServlet {
	private IOrderService orderService = new OrderService();
	private ILineService lineService = new LineService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderid = request.getParameter("id");
		lineService.deleFk(Integer.parseInt(orderid));
		orderService.deleteOrder(Integer.parseInt(orderid));
		
		//有问题
		/*
		 * Customer Fcustomer =
		 * (Customer)request.getSession().getAttribute("Fcustomer");
		 * 
		 * List<Order> orders = Fcustomer.getOrders(); orders.clear();
		 * request.getSession().setAttribute("Fcustomer", "Fcustomer");
		 */
		request.getRequestDispatcher("/user/order.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
