package com.member.lib.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.BookDAO;
import com.member.lib.service.BookService;

public class BookServiceImpl implements BookService
{
	private BookDAO bookDAO = new BookDAOImpl();
	
	@Override
	public Map<String, Object> insertBook(Map<String, Object> book)
	{
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.insertBook(book);
		rMap.put("msg", (result==1)?"도서입력 성공여":"도서입력 실패여");	
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateBook(Map<String, Object> book)
	{
		Map<String,Object> rMap = new HashMap<>();
		int result = bookDAO.updateBook(book);
		rMap.put("msg", (result==1)?"변경 성공여":"변경 실패여");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteBook(int bNum)
	{
		Map<String,Object> rMap = new HashMap<>();
		int result = bookDAO.deleteBook(bNum);
		rMap.put("msg", (result==1)?"도서 삭제 완료여":"도서 삭제 오류여");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectBookList(Map<String, Object> book)
	{
		return bookDAO.selectBookList(book);
	}

	@Override
	public Map<String, Object> selectBook(int bNum)
	{
		return bookDAO.selectBook(bNum);
	}
	public static void main(String[] args)
	{
		BookService bookService = new BookServiceImpl();
		Map<String,Object> map = new HashMap<>();
		map.put("b_title", "변신");
		map.put("b_author", "프란츠카프카");
		map.put("b_desc", "그로테스크1");
		map.put("b_num",41);
		
		System.out.println(bookService.updateBook(map));
	}
}
