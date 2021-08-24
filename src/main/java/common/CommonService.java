package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonService {
	
	// 파일 다운로드 처리
		public void fileDownload(String filename, String filepath, 
						HttpSession session, HttpServletResponse response) {
			File file = new File( session.getServletContext().getRealPath("resources") + "/" + filepath);
			String mime = session.getServletContext().getMimeType(filename); 	// 파일의 형태를 확인 (확장자를 통해...)
			response.setContentType(mime);
			
			
			// 파일 첨부한 후 쓰기 처리
			try {
				// 한글 파일명 깨짐 오류 처리, 파일명 공백을 
				filename = URLEncoder.encode(filename, "utf-8").replaceAll("\\+", "%20");
				
				response.setHeader("content-disposition", "attachment; filename=" + filename);	// 헤더 정보에 파일을 지정
				ServletOutputStream out = response.getOutputStream();
				FileCopyUtils.copy(new FileInputStream(file), out);
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	// 파일 업로드 처리
	public String fileUpload(String category, MultipartFile file, HttpSession session ) {
		// 업로드 할 위치
		String resources = session.getServletContext().getRealPath("resources");
		// D:\Study_Spring\Workspace\.metadata\plungins\....\iot\resources
		String folder = resources + "/upload/" + category + "/" + new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		// 			임의의 이름 생성				실제 파일명 .getOriginalFilename
		
		File dir = new File( folder );
		if (! dir.exists() ) dir.mkdirs();		
			try {
				file.transferTo(new File( folder, uuid ));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		// upload/notice/2021/07/27 askdjal_abc.txt	
		// 실제 프로젝트시 업로드할 폴더와 임의의 이름까지 리턴 
		return folder.substring(resources.length() + 1 ) + "/" + uuid;
	}
	
	
	// 이메일 전송 메소드
	public void sendEmail(String name, String email, HttpSession session) {
		// 기본 이메일
		// simpleSend(name, email);
		
		// 파일 첨부하는 이메일
		// attachSend(name, email, session);
		
		// html 태그 형태로 보내는 이메일
		htmlSend(name, email, session);		
		
	}
	
	// html 태그 형태로 보내는 이메일 보내는 메소드
	private void htmlSend(String name, String email, HttpSession session) {
		HtmlEmail mail = new HtmlEmail();
		
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");
		mail.setDebug(true);
		
		mail.setAuthentication("cla7901", "qkqh7901*");
		mail.setSSLOnConnect(true);	// 로그인 버튼 누르기
		
		try {
			mail.setFrom("cla7901@naver.com", "한울 IoT 관리자");
			mail.addTo(email, name);
			
			mail.setSubject("한울 IoT 과정 가입 축하메일!");
			
			StringBuffer msg = new StringBuffer("<html>");
			msg.append("<body>");
			msg.append("<a href='https://www.google.com'>구글<img src='https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png' /></a>");
			msg.append("<hr>");
			msg.append("<h3>한울 IoT 과정 가입 축하</h3>");
			msg.append("<p>가입을 축하합니다.</p>");
			msg.append("<p>프로젝트까지 마무리하고 <br> 모두 취업에 성공하세요~</p>");
			msg.append("</body></html>");
			
			mail.setHtmlMsg(msg.toString());
			
			// 파일 첨부하기
			EmailAttachment file = new EmailAttachment();
			file.setPath(session.getServletContext().getRealPath("resources/css/common.css"));
			mail.attach(file);
			
			file = new EmailAttachment();
			file.setURL(new URL("https://mvnrepository.com/assets/images/392dffac024b9632664e6f2c0cac6fe5-logo.png"));
			mail.attach(file);
			
			mail.send();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// 파일 첨부하여 이메일 보내는 메소드
	private void attachSend(String name, String email, HttpSession session) {
		MultiPartEmail mail = new MultiPartEmail();
		
		// 메일 서버 지정
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");
		mail.setDebug(true);	// 메일전송 디버그 모드 설정
		
		// 로그인하기 위한 아이디/비번 지정
		mail.setAuthentication("cla7901", "qkqh7901*");
		mail.setSSLOnConnect(true);	// 로그인 버튼 누르기
		
		try {
			mail.setFrom("cla7901@naver.com", "한울 IoT 관리자");
			mail.addTo(email, name);
			mail.setSubject("한울 IoT 과정 : 파일 첨부");
			mail.setMsg("과정 가입을 축하합니다!\n 첨부된 파일을 확인하세요.");
			
			
			// 이메일 파일 첨부 클래스 생성
			EmailAttachment file = new EmailAttachment();
			// 첨부할 파일 지정 (컴퓨터 내)
			file.setPath("D:\\개발자프로그램\\개발자용-파일 다운로드-링크.txt");			
			mail.attach(file);	
			
			// 프로젝트 내부 파일을 보낼 땐.. session 객체 사용
			file = new EmailAttachment();
			file.setPath(session.getServletContext().getRealPath("resources/images/") + "hanul.png");
			mail.attach(file);
			
			// URL로 파일 첨부
			file = new EmailAttachment();
			file.setURL(new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
			mail.attach(file);
			
			mail.send();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	// 기본 이메일 보내는 메소드
	private void simpleSend(String name, String email) {
		SimpleEmail mail = new SimpleEmail();
		
		// 메일 서버 지정
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");
		mail.setDebug(true);		// 메일전송 디버그 모드 설정
		
		// 로그인하기 위한 아이디/비번 지정
		mail.setAuthentication("cla7901", "qkqh7901*");
		mail.setSSLOnConnect(true);	// 로그인 버튼 누르기
		
		try {
			mail.setFrom("cla7901@naver.com", "한울 IoT 관리자");	// 보내는 사람 지정
			mail.addTo(email, name);	// 받는 사람 지정 (여러명에게 보낼 땐 리스트 등 활용)
			
			mail.setSubject("한울 IoT 과정");
			mail.setMsg(name + "님! IoT 과정 가입을 축하합니다.~");
			
			// 메일 보내기 버튼 클릭
			mail.send();
			
		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}

	// 
	public Map<String, Object> json_requestAPI(StringBuffer url) {
		JSONObject json = new JSONObject( requestAPI(url));		
		json = json.getJSONObject("response");

		// 조회 한도 초과 여부 확인 resultCode 가 99 이면 한도초과, 0이면 정상 		
		int code = json.getJSONObject("header").getInt("resultCode");
		if (code == 0 ) { 			// 정상
			
			json = json.getJSONObject("body");
			
			// 전체 업체 수 가져오기
			int count = 0;
			if (json.has("totalCount") ) count = json.getInt( "totalCount" );
			if (json.get("items") instanceof JSONObject) {
				json = json.getJSONObject("items");
				
				// 배열 형태가 아닌 경우 배열 형태로 변경
				if(json.get("item") instanceof JSONObject )
					json.put("item", new JSONArray().put(0, json.get("item")));
				
			} // if
				// json = json.getJSONObject("items");
			json.put("count", count);
		} else {				// 한도초과시
			json.put("resultCode", code);
		}
		return json.toMap();	// 맵 형태로 값을 전달
	}
	
	// API 요청을 위한 Service
	public String requestAPI(StringBuffer url, String property) {
		String result = "";
		try {
			/* URL url = new URL(apiURL); */
			HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
			// 전달받은 url 을 지정
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", property);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode >= 200 && responseCode <= 300) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8")); // 한글 깨짐 처리
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			con.disconnect();
			result = res.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // try ~ catch
		return result;
	}
	
	public String requestAPI(StringBuffer url) {
		String result = "";
		try {
			/* URL url = new URL(apiURL); */
			HttpURLConnection con = (HttpURLConnection) new URL(url.toString()).openConnection();
			// 전달받은 url 을 지정
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode >= 200 && responseCode <= 300) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8")); // 한글 깨짐 처리
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			con.disconnect();
			result = res.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // try ~ catch
		return result;
	}
	
	
	
	
}
