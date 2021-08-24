package com.so.storage.common;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import member.MemberVO;
import reservation.ReserServiceImpl;
import reservation.ReserVO;

@Controller
public class ReservationController {
	
	@Autowired
	private ReserServiceImpl service;

//	@RequestMapping ("/list.rv")
//	public String list(HttpSession session, Model model) {
//		session.setAttribute("category", "rv");
//		return "reservation/reservation";
//	}
	
	@ResponseBody
	@RequestMapping("/and_reser_insert")
	public void join(HttpServletResponse res, ReserVO vo ) throws Exception {
		MemberVO mVo = new MemberVO();
		
		String reser_product_id = vo.getProduct_id();
		String reser_product_type = vo.getProduct_type();
		String reser_booking_member = mVo.getId();
		String reser_booking_start = vo.getBooking_start();
		String reser_booking_end = vo.getBooking_end();
		String reser_product_using = vo.getProduct_using();
		vo = new ReserVO(  reser_product_id, reser_product_type, reser_booking_member ,reser_booking_start, reser_booking_end, reser_product_using );
		
		service.reser_insert(vo);
		
		//service.reser_list();
		
		common_gson(res, vo);
		
	}
	
	
	@ResponseBody
	   @RequestMapping("/and_reservationList")
	   public void mg_reserList(HttpServletResponse res) throws Exception {
	      
	      List<ReserVO> list = service.reser_list();
	   
	      common_gson(res, list);
	   }
	
	public void common_gson(HttpServletResponse res, List<ReserVO> vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
	
	public void common_gson(HttpServletResponse res, ReserVO vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
	
	
}
