package com.so.storage.common;

//import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
//import com.google.gson.JsonArray;

import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberServiceImpl service;

	@ResponseBody
	@RequestMapping("/and_login")
	public void login(String id, String pw, HttpServletResponse res) throws Exception {

		System.out.println(id + ", " + pw);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id); // 가져온 값 hashmap 에 담아줌
		map.put("pw", pw);
		
		MemberVO vo = service.member_login(map);
		
		common_gson(res, vo);
	}
	
	@ResponseBody
	@RequestMapping("/and_join")
	public void join(MemberVO vo, HttpServletResponse res) throws Exception {
		//vo = new MemberVO(id, pw, name, email, tel);
		//vo = new MemberVO(vo.getId(), vo.getPw(), vo.getName(), vo.getEmail(), vo.getTel());
		String id = vo.getId();
		String pw = vo.getPw();
		String name = vo.getName();
		String email = vo.getEmail();
		String tel = vo.getTel();
		vo = new MemberVO(id, pw, name, email, tel);
		service.member_join(vo);
		
		common_gson(res, vo);
	}
	
	@ResponseBody
	@RequestMapping("/and_leave")
	public void member_leave(String id, HttpServletResponse res) throws Exception {
		service.member_delete(id);
		
		MemberVO vo = new MemberVO();
		vo.getId();
		vo.getPw();
		vo.getName();
		vo.getEmail();
		vo.getTel();
		
		common_gson(res, vo);
	}
	
	@ResponseBody
	@RequestMapping("/and_pwchk")
	public void member_leave_pwchk(String pw, HttpServletResponse res) throws Exception {
		MemberVO vo = service.member_pw_check(pw);
		
		common_gson(res, vo);
	}	
	
	@ResponseBody
	@RequestMapping("/and_idChk")
	public boolean join_idChk(String id, HttpServletResponse res) throws Exception {
		
		return service.member_id_check(id);

// 아래 2줄 추가 주석 (08/03 18:45)		
//		 MemberVO vo = service.member_id_check(id);
//		
//		 common_gson(res, vo);
		 
	}
	
	@ResponseBody
	@RequestMapping("/and_accountUpdate")
	public void account_update(MemberVO vo, HttpServletResponse res) throws Exception {
		service.member_update(vo);
		common_gson(res, vo);
	}
	
	@ResponseBody @RequestMapping("/and_memberList")
	public void mg_memberList(HttpServletResponse res) throws Exception {
		List<MemberVO> list = service.mg_member_list();
		common_gson(res, list);
	}
	
	public void common_gson(HttpServletResponse res, MemberVO vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
	
	public void common_gson(HttpServletResponse res, List<MemberVO> vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
}
