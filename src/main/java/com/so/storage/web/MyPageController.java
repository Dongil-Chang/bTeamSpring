package com.so.storage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.MemberServiceImpl;

@Controller
public class MyPageController {
	@Autowired
	private MemberServiceImpl service;
	
	// 마이페이지 화면 이동
	@RequestMapping("/mypage.my")
	public String mypage(HttpSession session, Model model) {
		session.setAttribute("category", "my");
		return "mypage/mypages";
	}

	// 마이페이지 정보 수정 화면 전 비밀번호 확인 페이지 이동
	@RequestMapping("/myinfo.my")
	public String myinfo_chk(HttpSession session) {
		session.setAttribute("my_category", "myinfo");
		return "mypage/myinfo";
	}

	// 마이페이지 정보 수정 전 비밀번호 확인
	@RequestMapping("/myinfo_chk")
	public String myinfo_chk(String password) {
		service.member_pw_check(password);
		return "mypage/";
	}
	
}
