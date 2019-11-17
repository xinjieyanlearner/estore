package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.IBookService;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.impl.BookService;
import com.briup.app.estore.service.impl.CustomerService;
import com.briup.app.estore.shoppingcart.ShoppingCart;
import com.briup.app.estore.util.MD5Util;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICustomerService customerService = new CustomerService();
	private ShoppingCart shoppingCart = new ShoppingCart();
	private IBookService  bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//加密
		String calcpwd = MD5Util.calc(password);
		Customer customer = new Customer();
		
		customer.setName(name);
		customer.setPassword(calcpwd);
		Customer Fcustomer = customerService.findByName(customer.getName());
		//判断该用户是否注册
		try {
			if(customer.getName().equals(Fcustomer.getName())) {
				//判断密码是否正确
				if(customer.getPassword().equals(Fcustomer.getPassword())) {
					// 主页上展示的数据
						List<Book> books = bookService.findBooks();
						request.getSession().setAttribute("Fcustomer",Fcustomer);
						request.setAttribute("username", customer.getName());
						request.getSession().setAttribute("booklist", books);
						request.getSession().setAttribute("shoppingCart", shoppingCart);
						request.getRequestDispatcher("/index.jsp").forward(request, response);
					
					
				}else {
					response.getWriter().print("你的密码不正确！");
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//该用户没有注册
			response.sendRedirect("/register.jsp");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
