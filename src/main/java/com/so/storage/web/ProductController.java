package com.so.storage.web;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.MemberVO;
import product.ProductPage;
import product.ProductServiceImpl;
import product.ProductVO;

@Controller
public class ProductController {

	@Autowired private ProductServiceImpl service;
	@Autowired private ProductPage page;
	
	
	// 신규 상품 저장처리 요청
	@RequestMapping("/insert.pd")
	public String insert(ProductVO vo, HttpSession session) {

		// 화면에서 입력한 정보를 DB에 저장한 후 화면으로 연결		
		service.product_insert(vo);
		return "redirect:list.pd";	// 리턴 시 상품 목록 화면으로 이동 처리
	}
	
	//  신규 상품 등록 화면 요청
	@RequestMapping("/new.pd")
	public String product(Model model) {
		model.addAttribute("page", service.product_list(page) );
		return "product/new";
	}
	
	//  상품 목록 화면 요청
	@RequestMapping("/list.pd")
	public String list(HttpSession session, Model model, 
					String search, String keyword,
				@RequestParam(defaultValue = "1") int curPage) {
			
		session.setAttribute("m_category", "list");
		
	//  DB에서 상품 목록을 조회해와 목록화면에 출력		
	//	model.addAttribute("list", service.product_list());
		
		// 페이지 처리된 글 목록조회
		page.setCurPage(curPage);	// 페이지의 현재 페이지는 curPage 이며

		// 게시글 검색을 위한 처리
		page.setSearch(search);
		page.setKeyword(keyword);
		
		model.addAttribute("page", service.product_list(page) );
		return "product/list";
	}
}
