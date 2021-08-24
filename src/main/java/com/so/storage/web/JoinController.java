package com.so.storage.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.CommonService;
import manager.ProvisionVO;
import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class JoinController {

	@Autowired private MemberServiceImpl service;
	@Autowired private CommonService common;
	
	// 회원가입 처리 요청
		@ResponseBody @RequestMapping(value = "/join", produces = "text/html; charset=utf-8")
		public String join(MemberVO vo, HttpServletRequest request, HttpSession session) {
			// 회원가입 화면에서 입력한 정보를 DB 에 저장한 후
			// 회원 가입 축하 메시지창을 띄운다.
			StringBuffer msg = new StringBuffer("<script>");
			if (service.member_join(vo)) {
				// 회원가입 성공시 축하메일 보내기
				common.sendEmail(vo.getName(), vo.getEmail(), session);
				
				msg.append("alert('회원가입을 축하합니다.^^'); location='")
					.append(request.getContextPath())
					.append("'");
			} else {
				msg.append("alert('회원가입 실패 ㅠ.ㅠ'); location='member' " );
			}		
			msg.append("</script>");
			return msg.toString();
		}
	
	//아이디 중복확인 요청
		@ResponseBody @RequestMapping("/idchk")
		public boolean member_id_check(String id) {
		    return service.member_id_check(id);
		}
	
	// 회원가입 화면 요청
		@RequestMapping("/member")
		public String member(HttpSession session) {
			session.setAttribute("category", "join");
			return "member/join";
		}
		
	// 개인정보 수집 동의 페이지 요청
		@RequestMapping("/privacy_usage.me")
		public String privacy_usage(Model model) {
			model.addAttribute("vo", service.provision_list());
			return "member/privacy-usage";
		}
		
	// 서비스 이용약관 페이지 요청
		@RequestMapping("/join_service.me")
		public String join_service (Model model) {
			model.addAttribute("vo", service.join_service_list());
			return "member/join_service";
		}
	
}
