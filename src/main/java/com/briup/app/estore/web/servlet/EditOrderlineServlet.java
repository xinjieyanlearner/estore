package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class EditOrderlineServlet
 */
@WebServlet("/editOrderline")
public class EditOrderlineServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart shoppingCart = (ShoppingCart)request.getSession().getAttribute("shoppingCart");
		String bookid = request.getParameter("bookid");
		int key = Integer.parseInt(bookid);
		String linenum = request.getParameter("num");
		int num = Integer.parseInt(linenum);
		shoppingCart.update(key, num);
		request.getRequestDispatcher("/user/shoppingCart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
