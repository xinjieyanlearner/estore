package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		List<Book> selectAll = mapper.selectAll();
		selectAll.forEach(book->System.out.println(book));
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
