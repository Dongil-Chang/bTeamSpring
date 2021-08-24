package com.so.storage.web;

import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import common.CommonService;
import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class LoginController {

	@Autowired private CommonService common;
	@Autowired private MemberServiceImpl service;	
	
	private String naver_client_id = "ovR_Ev7EIZwvwrn0hdtU";
	private String kakao_client_id = "cc9bdae0822f9a889e46d57641df634c";
	private String google_client_id = "020138534296-c4itm32e1q58c2ggrqfkod81b4b4cntt.apps.googleusercontent.com";
	
	// 구글 로그인 요청
		@ResponseBody
		@RequestMapping("/googleLogin")
		public String googleLogin(MemberVO vo, HttpSession session, RedirectAttributes rttr, MemberVO mvo) throws Exception{
			MemberVO returnVO = service.loginMemberByGoogle(vo);
			String mvo_ajaxid = mvo.getId(); 
			System.out.println("C: 구글아이디 포스트 db에서 가져온 vo "+ vo);
			System.out.println("C: 구글아이디 포스트 ajax에서 가져온 id "+ mvo_ajaxid);
			
			if(returnVO == null) { //아이디가 DB에 존재하지 않는 경우
				//구글 회원가입
				service.joinMemberByGoogle(vo);	
				
				//구글 로그인
				returnVO = service.loginMemberByGoogle(vo);
				session.setAttribute("id", returnVO.getId());			
				rttr.addFlashAttribute("mvo", returnVO);
			}
			
			if(mvo_ajaxid.equals(returnVO.getId())){ //아이디가 DB에 존재하는 경우
				//구글 로그인
				service.loginMemberByGoogle(vo);
				session.setAttribute("id", returnVO.getId());			
				rttr.addFlashAttribute("mvo", returnVO);
			}else {//아이디가 DB에 존재하지 않는 경우
				//구글 회원가입
				service.joinMemberByGoogle(vo);	
				
				//구글 로그인
				returnVO = service.loginMemberByGoogle(vo);
				session.setAttribute("id", returnVO.getId());			
				rttr.addFlashAttribute("mvo", returnVO);
			}
			
			return "redirect:/";
		}
	
		//카카오로그인요청
		  @RequestMapping(value="/kakaoLogin")
		    public String kakaoLogin(HttpSession session) {
//		        StringBuffer loginUrl = new StringBuffer();
//		        loginUrl.append("https://kauth.kakao.com/oauth/authorize?client_id=");
//		        loginUrl.append("3a5fc5678034a31a4a50212f089a8cf7"); 
//		        loginUrl.append("&redirect_uri=");
//		        loginUrl.append("http://localhost/web/kakaocallback"); 
//		        loginUrl.append("&response_type=code");
				String state = UUID.randomUUID().toString();
				session.setAttribute("state", state);
				
		        StringBuffer url = new StringBuffer(
		        		"https://kauth.kakao.com/oauth/authorize?response_type=code");
		        url.append("&client_id=").append(kakao_client_id);
		        url.append("&redirect_uri=http://localhost:8003/storage/kakaocallback");
		        url.append("&state=").append(state);
		        
//		        return "redirect:"+loginUrl.toString();
		        return "redirect:"+url.toString();
		    }
		
		  
		  
		  @RequestMapping("/kakaocallback")
			public String kakaocallback(@RequestParam(required = false) String code
					, String state, HttpSession session
										, @RequestParam(required = false) String error) {
				if ( !state.equals( session.getAttribute("state") ) || error!=null ) {
					return "redirect:/";
				}
				
				StringBuffer url = new StringBuffer(
					"https://kauth.kakao.com/oauth/token?grant_type=authorization_code");
				url.append("&client_id=").append(kakao_client_id);
				//url.append("&client_secret=FZn2ljqDGsK4MyRotzIhV8kd169VMWom");
				url.append("&code=").append(code);
				url.append("&state=").append(state);
				
				
				JSONObject json = new JSONObject( common.requestAPI(url) );
				String token = json.getString("access_token");
				String type = json.getString("token_type");
				
				url = new StringBuffer("https://kapi.kakao.com/v2/user/me");
				json = new JSONObject( common.requestAPI(url, type + " " + token) );
				
				JSONObject top = json;
				
				MemberVO vo = new MemberVO();
				vo.setSocial_type("kakao");
				vo.setId( json.get("id").toString() );
				
				json = json.getJSONObject("kakao_account");
				vo.setSocial_email( json.has("email") ? json.getString("email") : "");
				json = json.getJSONObject("profile");
				vo.setName( json.getString("nickname") );
				
				if( service.member_social_email(vo) )
					service.member_social_update(vo);
				else 
					service.member_social_insert(vo);
				
				session.setAttribute("loginInfo", vo);
				
				return "redirect:/";
			}
		
		
	
	// 네이버 로그인 요청
		@RequestMapping("/naverLogin")
		public String naverLogin(HttpSession session) {
			
			// 세션상태 토큰으로 사용할 문자열 생성
			String state =  UUID.randomUUID().toString();
			session.setAttribute("state", state);
			
			// 네아로 연동 요청문 샘플
			// https://nid.naver.com/oauth2.0/authorize?response_type=code
			//&client_id=CLIENT_ID
			//&state=STATE_STRING
			//&redirect_uri=CALLBACK_URL
			
			// String 타입의 긴 문장을 입력하기 위하여 StringBuffer 사용하였으며 연결을 위하여  append  메소드를 활용하여 적용
			StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/authorize?response_type=code");
			url.append("&client_id=").append(naver_client_id);
			url.append("&state=").append(state);
			url.append("&redirect_uri=http://localhost:8003/storage/navercallback");
			return "redirect:" + url.toString();
		}
		
		@RequestMapping("/navercallback")
		public String navercallback(@RequestParam(required = false) String code, 
									String state, HttpSession session,
									@RequestParam(required = false) String error) {
			// @RequestParam(required = false) String code : code 는 꼭 필요한 값이 아니라는 의미(전송받지 않을 수 있다...)
			
			// 상태 토큰이 일치하지 않거나 콜백 실패시 오류가 발생시 토큰 발급 불가
			if(!state.equals(session.getAttribute("state")) || error != null ) { // state 값이 맞지 않거나 error 가 없으면 토큰 발급 불가 
				return "redirect:/"; // 메인 페이지로 이동
			}
			
			// 접근 토큰발급 요청문 샘플
			// https://nid.naver.com/oauth2.0/token?grant_type=authorization_code
			// &client_id=jyvqXeaVOVmV
			// &client_secret=527300A0_COq1_XV33cf
			// &code=EIc5bFrl4RibFls1
			// &state=9kgsGTfH4j7IyAkg

			StringBuffer url = new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
			url.append("&client_id=").append(naver_client_id);
			url.append("&client_secret=boLpH514TX");
			url.append("&code=").append(code);
			url.append("&state=").append(state);
			
			JSONObject json = new JSONObject(common.requestAPI(url));
			String token = json.getString("access_token");
			String type = json.getString("token_type");
			
//			curl  -XGET "https://openapi.naver.com/v1/nid/me" \
//		      -H "Authorization: Bearer AAAAPIuf0L+qfDkMABQ3IJ8heq2mlw71DojBj3oc2Z6OxMQESVSrtR0dbvsiQbPbP1/cxva23n7mQShtfK4pchdk/rc="
			url = new StringBuffer("https://openapi.naver.com/v1/nid/me");
			json = new JSONObject(common.requestAPI(url, type + " " + token));
			
			if (json.getString("resultcode").equals("00")) {
				json = json.getJSONObject("response");
				
				MemberVO vo = new MemberVO();
				vo.setSocial_type("naver");
				vo.setId(json.getString("id") );
				vo.setSocial_email(json.getString("email"));
				vo.setName(json.getString("name"));
//				vo.setGender(json.has("gender") && json.getString("gender").equals("F") ? "여" : "남");
				
				// 네이버 최초 로그인인 경우 회원정보 저장
				// 네이버 로그인 이력이 있어 회원정보가 있다면 변경 저장
				
				if(service.member_social_email(vo) )
					service.member_social_update(vo);
				else
					service.member_social_insert(vo);
				
				
				session.setAttribute("loginInfo", vo);
			}
			
//			{
//				  "resultcode": "00",
//				  "message": "success",
//				  "response": {
//				    "email": "openapi@naver.com",
//				    "nickname": "OpenAPI",
//				    "profile_image": "https://ssl.pstatic.net/static/pwe/address/nodata_33x33.gif",
//				    "age": "40-49",
//				    "gender": "F",
//				    "id": "32742776",
//				    "name": "오픈 API",
//				    "birthday": "10-01"
//				  }
//			}
			
			common.requestAPI(url, type + " " + token);
			
			return "redirect:/";
		}
		
		// 로그아웃처리 요청
		@RequestMapping("/logout")
		public String logout(HttpSession session) {
			// 세션에 담김 로그인정보를 삭제한다.
			session.removeAttribute("loginInfo"); // session 에 담긴 "loginInfo" 값을 삭제
			return "redirect:/"; // 로그아웃 시 루트(home.jsp)로 이동
		}
		
		// 로그인처리 요청
		@ResponseBody @RequestMapping("/webLogin")
		public Boolean login(String id, String pw, HttpSession session) {
			// 화면에서 전송한 아이디, 비밀번호가 일치하는 회원정보를 DB에서 조회해온다.
			// 매개변수 2개를 HashMap 형태로 담아 service 에 전달 
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			map.put("pw", pw);
			MemberVO vo = service.member_login(map);
			session.setAttribute("loginInfo", vo);
			return vo == null ? false : true; // 결과값이 null 이면 false / null이 아니면 true
		}
		
	//로그인화면 출력
	@RequestMapping ("/login")
	public String login(HttpSession session) {
		session.setAttribute("category", "login");
		return "member/login";
	}
}
