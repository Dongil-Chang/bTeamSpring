package member;

import java.util.HashMap;
import java.util.List;

import manager.ProvisionVO;

public interface MemberService {
	boolean member_join(MemberVO vo); //회원가입시 회원정보 저장
	MemberVO member_login(HashMap<String, String> map); //아이디/비번 일치하는 회원정보 조회
	//dao 에서 sql문 사용할 때, mapper에 두 개의 파라미터 보낼 수 없으므로 HashMap으로 두 개의 파라미터를 하나로 묶음
	
	
	//MemberVO member_id_check(String id); //아이디 중복확인
	boolean member_id_check(String id); //아이디 중복확인
	MemberVO member_pw_check(String pw); //회원탈퇴시 비밀번호 확인
	boolean member_update(MemberVO vo); //회원정보 변경저장
	boolean member_delete(String id); //회원탈퇴시 회원정보 삭제
	boolean member_social_email(MemberVO vo); //소셜회원 정보 존재여부
	boolean member_social_insert(MemberVO vo); //소셜회원정보 신규저장
	boolean member_social_update(MemberVO vo); //소셜회원정보 변경저장
	
	MemberVO loginMemberByGoogle(MemberVO vo); // 구글 로그인 처리
	void joinMemberByGoogle(MemberVO vo);		// 구글 회원 가입
	
	ProvisionVO provision_list();// 회원 약관 내용 조회
	ProvisionVO join_service_list();// 서비스 이용 약관 내용 조회
	
	
	List<MemberVO> mg_member_list(); 	// 회원목록 조회(안드로이드)
}
