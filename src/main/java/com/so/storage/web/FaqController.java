package com.so.storage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import faq.FaqPage;
import faq.FaqServiceImpl;
import faq.FaqVO;


@Controller
public class FaqController {
	
	@Autowired private FaqServiceImpl service;
	@Autowired private FaqPage page;

	// Faq 글 삭제 처리
		@RequestMapping("/faq_delete.ma")
		public String faq_delete(String id) {
			service.faq_delete(id);
			return "redirect:faq_list.ma";
		}
		
		// Faq 글 수정 처리
		@RequestMapping("/faq_update.ma")
		public String faq_update(FaqVO vo) {
			service.faq_update(vo);
			return "redirect:faq_detail.ma?id=" + vo.getFaq_code();
		}
		
		// Faq 수정 화면 요청
		@RequestMapping("/faq_modify.ma")
		public String faq_modify(String id, Model model) {
			// 해당 글의 정보를 DB에서 조회하여 화면 출력
			model.addAttribute("vo", service.faq_detail(id));
			return "manager/faq_modify";
		}
		
		// Faq 상세화면 페이지 요청
		@RequestMapping("/faq_detail.ma")
		public String faq_detail(String id, Model model) {
			
			// 해당 Faq 글을 DB에서 조회하여 화면 출력
			model.addAttribute("vo", service.faq_detail(id));
			model.addAttribute("crlf", "\r\n");
			return "manager/faq_detail";
		}
		
		// Faq 신규 글 저장 처리
		@RequestMapping("/faq_insert.ma")
		public String faq_insert(FaqVO vo) {
			// 화면에서 입력한 정보를 DB에 신규 저장한 후 목록화면 연결
			service.faq_insert(vo);
			return "redirect:faq_list.ma";
		}
		
		// Faq 글쓰기 화면 요청
		@RequestMapping("/faq_new.ma")
		public String faq_new() {
			return "manager/faq_new";
		}
		
		// Faq 목록 조회 및 화면 요청
		@RequestMapping("/faq_list.ma")
		public String faq_list (HttpSession session, Model model, 
				String search, String keyword,
			@RequestParam(defaultValue = "1") int curPage) {
			
			// 페이지 처리된 글 목록조회
			page.setCurPage(curPage); // 페이지의 현재 페이지는 curPage 이며

			// 게시글 검색을 위한 처리
			page.setSearch(search);
			page.setKeyword(keyword);
			
			
			// Faq 목록 조회하여 화면에 출력		
			model.addAttribute("page", service.faq_list(page));
			return "manager/faq_list";
		}
	
}
