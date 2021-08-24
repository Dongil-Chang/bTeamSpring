package com.so.storage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import manager.ManagerServiceImpl;
import manager.ProvisionVO;
import member.MemberPage;

@Controller
public class CommonController {	
	
	@Autowired private ManagerServiceImpl service;
	@Autowired private MemberPage page;	
	
	//이용안내 화면 요청
	@RequestMapping("/guide.gu")
	public String list(HttpSession session, Model model) {
		session.setAttribute("category", "gu");
		return "guide/guide";
	}
	
	// 이용약관 삭제 처리
	@RequestMapping("/provision_delete.ma")
	public String provision_delete(String id) {
		service.provision_delete(id);
		return "redirect:provision.ma";
	}
	
	// 이용약관 수정 저장 처리
	@RequestMapping("/provision_update.ma")
	public String provision_update(ProvisionVO vo) {
		service.provision_update(vo);
		return "redirect:provision_detail.ma?id=" + vo.getProvision_code();	
		// 상세 화면 연결을 위해 provision_code 를 가준으로 화면 이동
	}
	
	// 이용약관 수정화면 페이지 요청
	@RequestMapping("/provision_modify.ma")
	public String provision_modify(String id, Model model) {
		model.addAttribute("vo", service.provision_detail(id));
		return "manager/provision_modify";
	}

	// 이용약관 상세화면 페이지 요청
	@RequestMapping("/provision_detail.ma")
	public String provision_detail(String id, Model model) {
		
		// 해당 이용약관 글을 DB에서 조회하여 화면 출력
		model.addAttribute("vo", service.provision_detail(id));
		model.addAttribute("crlf", "\r\n");
		return "manager/provision_detail";
	}
	
	// 이용약관 글 저장
	@RequestMapping("/provision_insert.ma")
	public String provision_insert(ProvisionVO vo) {
		service.provision_insert(vo);
		return "redirect:provision.ma";
	}
	
	// 이용약관 저장 페이지 요청
	@RequestMapping("/provision_new.ma")
	public String provision_new() {
		return "manager/provision_new";
	}

	// 이용약관 목록 조회 및 화면 요청
	@RequestMapping("/provision.ma")
	public String provision(Model model) {
		
		// 이용약관 목록 조회하여 화면에 출력
		model.addAttribute("provision", service.provision_list());
		return "manager/provision_list";
	}
	
	// 관리자 페이지 화면 요청
	@RequestMapping("/master.ma")
	public String manager(HttpSession session) {
		session.setAttribute("category", "ma");
		return "manager/master";
	}
	
	// 회원 목록 조회
	@RequestMapping("/list.ma")
	public String member_list(HttpSession session, Model model, 
			String search, String keyword,
		@RequestParam(defaultValue = "1") int curPage) {
		
		// 페이지 처리된 글 목록조회
		page.setCurPage(curPage);	// 페이지의 현재 페이지는 curPage 이며
				
		// 게시글 검색을 위한 처리
		page.setSearch(search);
		page.setKeyword(keyword);
				
		// 회원 목록 조회하여 화면에 출력		
		model.addAttribute("page", service.member_list(page) );
		return "manager/member_list";
	}
	
}