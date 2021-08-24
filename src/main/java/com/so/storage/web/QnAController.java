package com.so.storage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import faq.FaqPage;
import faq.FaqServiceImpl;
import manager.ManagerServiceImpl;

@Controller
public class QnAController {

	@Autowired private FaqServiceImpl service;
	@Autowired private FaqPage page;
	
	@RequestMapping("/list.QnA")
	public String QnA(HttpSession session, Model model,
			String search, String keyword,
			@RequestParam(defaultValue = "1") int curPage) {
		session.setAttribute("category", "QnA");
		
		// 페이지 처리된 글 목록조회
		page.setCurPage(curPage); // 페이지의 현재 페이지는 curPage 이며

		// 게시글 검색을 위한 처리
		page.setSearch(search);
		page.setKeyword(keyword);
		
		model.addAttribute("page", service.faq_list(page));
		return "qna/qna_list";
	}
}
