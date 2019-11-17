package com.briup.app.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.service.IBookService;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class BookService implements IBookService {

	@Override
	public List<Book> findBooks() throws Exception {
		//调用dao层
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		List<Book> books = bookMapper.selectAll();
		return books;
	}
	
}
