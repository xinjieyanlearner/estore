package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Order;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.impl.OrderService;

/**
 * Servlet implementation class OrderinfoServlet
 */
@WebServlet("/orderinfo")
public class OrderinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IOrderService orderService = new OrderService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("id");
		System.out.println("jj"+orderId);
		Order order = orderService.findById(Integer.parseInt(orderId));
		request.getSession().setAttribute("order", order);
		request.getRequestDispatcher("/user/orderinfo.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
