package com.so.storage.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//예약하기 화면 요청
@Controller
public class WebReservationController {
	@RequestMapping ("/list.rv")
	public String list(HttpSession session, Model model) {
		session.setAttribute("category", "rv");
		return "reservation/reservationForm";
	}
	
}
