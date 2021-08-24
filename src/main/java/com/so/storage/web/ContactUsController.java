package com.so.storage.web;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import common.CommonService;
import contactus.ContactUsPage;
import contactus.ContactUsServiceImpl;
import contactus.ContactUsVO;
import member.MemberVO;
import notice.NoticeVO;

@Controller
public class ContactUsController {

	@Autowired private ContactUsServiceImpl service;
	@Autowired private ContactUsPage page;
	@Autowired private CommonService common;
	
	// 답글 저장 처리 요청
	@RequestMapping("/cu_reply_insert.qa")
	public String cu_reply_insert(ContactUsVO vo, MultipartFile file, HttpSession session) {
		// 첨부 파일이 있을 경우
		if (!file.isEmpty()) {
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.fileUpload("contactus", file, session));
		}
		vo.setBoard_writer(((MemberVO) session.getAttribute("loginInfo")).getId());
		service.cu_reply_insert(vo);
		return "redirect:cu_list.qa	";
	}
	
	
	// 공지글 답글 작성 화면 요청
	@RequestMapping("/cu_reply.qa")
	public String reply(int id, Model model) {
		model.addAttribute("vo", service.cu_detail(id));
		return "contact_us/cu_reply";
	}
	
	
	// 1:1 문의 내용 삭제 요청
	@RequestMapping("/cu_delete.qa")
	public String cu_delete(int id, HttpSession session) {
		// 첨부파일이 있는 글의 경우 디스크에서 첨부파일을 삭제한다.
		ContactUsVO contactus = service.cu_detail(id);	// 공지글에 대한 모든 정보 조회
		String uuid = session.getServletContext().getRealPath("resources") + "/" + contactus.getFilepath();
		if (contactus.getFilename() != null) {
			File file = new File(uuid);
			if (file.exists()) file.delete();	// upload 폴더 내 file 이 존재한다면 삭제 처리
		}
		
		service.cu_delete(id);
		return "redirect:cu_list.qa";
	}
	
	
	// 1:1 문의 수정 처리 요청
	@RequestMapping("/cu_update.qa")
	public String cu_update(ContactUsVO vo, String attach, 
			MultipartFile file, HttpSession session) {
		// 원래 파일이 첨부된 경우 이전 파일을 삭제하고 변경한 파일을 저장
				ContactUsVO contact = service.cu_detail(vo.getBoard_num());
				String uuid = session.getServletContext().getRealPath("resources") + "/" + contact.getFilepath();
				
				// 첨부파일이 있는 경우
				if( ! file.isEmpty() ) { 
					vo.setFilename(file.getOriginalFilename());
					vo.setFilepath( common.fileUpload("notice", file, session) );
					
					// 원래 첨부된 파일이 있었다면 물리적인 디스크에서 해당 파일 삭제
					if ( contact.getFilename() != null ) { // 서버에 파일이 있는지 파악
						File f = new File(uuid);	
						if (f.exists() ) f.delete(); // 기존 첨부 파일이 있다면 삭제				
					}
				} else {
				// 첨부 파일이 없는 경우
					// 1. 원래 첨부된 파일을 삭제하는 경우
					if ( attach.isEmpty() ) {
						if (contact.getFilename() != null ) { // 원래 첨부된 파일이 있었다면...
							File f = new File(uuid);
							if (f.exists()) f.delete();		// 물리 디스크의 파일을 삭제					
						}
					} else {			
					// 2. 원래 첨부된 파일을 그대로 사용하는 경우
						vo.setFilename(contact.getFilename() );
						vo.setFilepath(contact.getFilepath() );
					}
				}
				
				// 화면에서 변경입력한 정보를 DB에 변경 저장한 후 상세 화면으로 연결
		service.cu_update(vo);
		return "redirect:cu_detail.qa?id=" + vo.getBoard_num();
	}
	
	// 1:1 문의 수정 화면 요청
	@RequestMapping("/cu_modify.qa")
	public String cu_modify(int id, Model model) {
		// 해당 글의 정보를 DB에서 조회하여 수정화면에 출력		
		model.addAttribute("vo", service.cu_detail(id));
		return "contact_us/cu_modify";
	}
	
	// 문의 글의 첨부 파일 다운로드 요청
	@RequestMapping("/cu_download.qa")
	public void download(int id, HttpSession session, HttpServletResponse response) {
		// 해당 문의 글의 첨부파일 정보를 DB에서 조회해와 해당 파일을 서버로부터 다운로드 한다.
		ContactUsVO contactus = service.cu_detail(id);	// 상세정보를 조회해 NoticeVO 에 담음.
		common.fileDownload(contactus.getFilename(), contactus.getFilepath(), session, response);
	}
	
	// 1:1 문의 상세 화면 요청
	@RequestMapping("/cu_detail.qa")
	public String cu_detail(int id, Model model) {
		
		// 상세화면 요청 전 조회수 증가
		service.cu_read(id);
			
		// 해당 1:1 문의 글을 DB에서 조회하여 상세화면에 출력
		model.addAttribute("vo", service.cu_detail(id));
		model.addAttribute("crlf", "\r\n");
		return "contact_us/cu_detail";
	}
	
	// 1:1 문의글 summernote 이미지 파일 업로드 요청
	@RequestMapping(value="/uploadImageFile", produces = "application/json; charset=utf8")
	@ResponseBody
	public Object uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, HttpSession session )  {
		HashMap<String, Object> obj = new HashMap<String, Object>();
		
		obj.put("url", common.fileUpload("summernote", multipartFile, session));
		return obj;
	}
	
	
	// 1:1 문의 신규 내용 저장 요청
	@RequestMapping("/cu_insert.qa")
	public String cu_insert(ContactUsVO vo, HttpSession session,
							MultipartFile file) {
		MemberVO member = loginStatus(session); // 로그인된 회원정보를 가져옴
		if ( member == null ) return "redirect:cu_list.qa"; // 로그인 정보가 없으면 목록 화면으로 이동
		
		// 로그인 된 사용자의 id를 가져와 글쓴이(writer) 에 담기 위한 처리
		// vo.setBoard_writer(member.getId());
		
		vo.setBoard_writer( ((MemberVO) session.getAttribute("loginInfo")).getId());
		
		if (! file.isEmpty() ) {	// 파일이 있는 경우
			// 파일 첨부 처리 부분
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath( common.fileUpload("contactus", file, session));		
		}
		
		service.cu_insert(vo);
		return "redirect:cu_list.qa";
	}
	
	private MemberVO loginStatus(HttpSession session) {
		return (MemberVO) session.getAttribute("loginInfo");
	}
	
	// 1:1 문의 신규 내용 입력 화면 요청
	@RequestMapping("/cu_new.qa")
	public String cu_new(HttpSession session, Model model, String search, String keyword, 
			@RequestParam(defaultValue = "1") int curPage) {
		
		// session.getAttribute("loginInfo");
		MemberVO member = loginStatus(session); // 로그인된 회원정보를 가져옴
//		if ( member == null ) return "redirect:cu_list.qa"; 
		
		// 페이지 처리된 글 목록조회
		page.setCurPage(curPage);	// 페이지의 현재 페이지는 curPage 이며
				
		// 게시글 검색을 위한 처리
				page.setSearch(search);
				page.setKeyword(keyword);
				
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("page", page);
				map.put("admin", ((MemberVO)session.getAttribute("loginInfo")) .getSubcode());
				map.put("userid", ((MemberVO)session.getAttribute("loginInfo")) .getId());
				
//				model.addAttribute("page", service.cu_list(page));
				model.addAttribute("page", service.cu_list(map));
				model.addAttribute("uri", "cu_new.qa");
		
		return "contact_us/cu_new";
	}
	
	// 1:1 문의 목록 화면 요청
	@RequestMapping("/cu_list.qa")
	public String cu_list(HttpSession session, Model model, String search, String keyword, 
			@RequestParam(defaultValue = "1") int curPage) {
		session.setAttribute("category", "qa");
		
		// 페이지 처리된 글 목록조회
		page.setCurPage(curPage);	// 페이지의 현재 페이지는 curPage 이며
		
		// 게시글 검색을 위한 처리
		page.setSearch(search);
		page.setKeyword(keyword);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("admin", ((MemberVO)session.getAttribute("loginInfo")) .getSubcode());
		map.put("userid", ((MemberVO)session.getAttribute("loginInfo")) .getId());
		
//		model.addAttribute("page", service.cu_list(page));
		model.addAttribute("page", service.cu_list(map));
		model.addAttribute("uri", "cu_list.qa");
		return "contact_us/cu_list";
	}
}
