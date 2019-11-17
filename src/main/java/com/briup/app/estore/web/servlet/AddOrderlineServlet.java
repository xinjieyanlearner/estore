package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class AddOrderlineServlet
 */
@WebServlet("/add")
public class AddOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		ShoppingCart shoppingCart = (ShoppingCart)request.getSession().getAttribute("shoppingCart");
		Customer Fcustomer = (Customer)request.getSession().getAttribute("Fcustomer");
		
		
		
		 Book book = new Book(); 
		 book.setId(Integer.parseInt(id));
		 book.setName(name);
		 book.setPrice(Double.parseDouble(price));
		 Orderline line = new Orderline();
		 line.setBook(book);
		 
		 
		 
		
		shoppingCart.add(line);
		request.getSession().setAttribute("shoppingCart",shoppingCart);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
