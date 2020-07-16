package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.MemberDAO;
import com.member.lib.dao.impl.MemberDAOImpl;
import com.member.lib.service.MemberService;

public class MemberServiceImpl implements MemberService
{
	private MemberDAO memberDAO = new MemberDAOImpl();

	@Override
	public Map<String, Object> insertMember(Map<String, Object> Member)
	{
		int result = memberDAO.insertMember(Member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤버등록 완료여");
		if (result != 1)
		{
			rMap.put("msg", "멤버등록 오류여");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateMember(Map<String, Object> Member)
	{
		int result = memberDAO.updateMember(Member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤버변경 완료여");
		if (result != 1)
		{
			rMap.put("msg", "멤버변경 오류여");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteMember(int mNum)
	{
		int result = memberDAO.deleteMember(mNum);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤버삭제 완료여");
		if (result != 1)
		{
			rMap.put("msg", "멤버삭제 오류여");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> Member)
	{
		return memberDAO.selectMemberList(Member);
	}

	@Override
	public Map<String, Object> selectMember(int mNum)
	{

		return memberDAO.selectMember(mNum);
	}

	public static void main(String[] args)
	{
		MemberService memberService = new MemberServiceImpl();
//		Map<String,Object> rMap = memberService.deleteMember(11);

//		System.out.println(rMap);
		Map<String, Object> member = new HashMap<>();
		member.put("m_name", "신송희");
		member.put("m_id", "sophee");
		member.put("m_pwd", "1234");
		member.put("m_num", 21);
//		Map<String,Object> rMap=memberService.insertMember(member);
//		System.out.println(rMap);
//		List<Map<String, Object>> memberList = memberService.selectMemberList(member);
//		for (Map<String, Object> mem : memberList)
//		{
//			System.out.println(mem);
		
//		}
		System.out.println(memberService.updateMember(member));
		
		
	}
}
