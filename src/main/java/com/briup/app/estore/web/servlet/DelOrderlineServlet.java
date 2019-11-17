package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class DelOrderlineServlet
 */
@WebServlet("/delOrderline")
public class DelOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lineid = request.getParameter("lineid");
		
		
		ShoppingCart shoppingCart = (ShoppingCart)request.getSession().getAttribute("shoppingCart");
		System.out.println(shoppingCart);
		shoppingCart.delete(Integer.parseInt(lineid));
		
		//这一块有问题，修改之后跳转之后页面还是原来的样子
		request.getRequestDispatcher("/user/shoppingCart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
