package com.member.lib.service.impl;

import java.util.List;
import java.util.Map;

import com.member.lib.dao.LentDAO;
import com.member.lib.service.LentService;

public class LentServiceImpl implements LentService
{

	@Override
	public Map<String, Object> inserLent(Map<String, Object> lent)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateLent(Map<String, Object> lent)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteLent(int lNum)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectLentList(Map<String, Object> lent)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectLent(int lNum)
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Map<String, Object>> NotlentBookList()
	{
		return LentDAO.NotlentBookList();
	}
}
