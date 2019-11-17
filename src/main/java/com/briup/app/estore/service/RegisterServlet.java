package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.impl.CustomerService;
import com.briup.app.estore.util.MD5Util;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ICustomerService customerService = new CustomerService();
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path ="/register.jsp";
		request.getRequestDispatcher(path).forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接受请求中携带的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//加密
		String calcpwd = MD5Util.calc(password);
		String address = request.getParameter("address");
		String zip = request.getParameter("zip");
		
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		//2.把参数封装成对象
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPassword(calcpwd);
		customer.setAddress(address);
		customer.setZip(zip);
		customer.setTelephone(telephone);
		customer.setZip(email);
		//3调用service层方法处理业务逻辑
		String page ="/login.jsp";
		
		try {
			Customer findByName = customerService.findByName(customer.getName());
			//4.根据service层处理结果，选择合适的页面
			if(findByName !=null) {
				response.getWriter().print("该用户名已被使用！"+findByName.getName());
				//?如何用弹窗形式提醒用户
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}else {
			customerService.register(customer);
			request.getRequestDispatcher(page).forward(request, response);
			}
		} catch (Exception e) {
			response.getWriter().print(e.getMessage());
			e.printStackTrace();
		}
		//有异常跳回原页面
		
		
	}

}
