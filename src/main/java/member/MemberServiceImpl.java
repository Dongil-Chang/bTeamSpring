package member;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import manager.ProvisionVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired private MemberDAO dao;
	
	@Override
	public boolean member_join(MemberVO vo) {
		return dao.member_join(vo);
	}

	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		return dao.member_login(map);
	}

	@Override
	public boolean member_id_check(String id) {
		return dao.member_id_check(id);
	}

	@Override
	public boolean member_update(MemberVO vo) {
		return dao.member_update(vo);
	}

	@Override
	public boolean member_delete(String id) {
		return dao.member_delete(id);
	}

	@Override
	public boolean member_social_email(MemberVO vo) {
		return dao.member_social_email(vo);
	}

	@Override
	public boolean member_social_insert(MemberVO vo) {
		return dao.member_social_insert(vo);
	}

	@Override
	public boolean member_social_update(MemberVO vo) {
		return dao.member_social_update(vo);
	}

	@Override
	public MemberVO member_pw_check(String pw) {
		return dao.member_pw_check(pw);
	}

	@Override
	public ProvisionVO provision_list() {
		return dao.provision_list();
	}

	@Override
	public ProvisionVO join_service_list() {
		return dao.join_service_list();
	}

	@Override
	public List<MemberVO> mg_member_list() {
		return dao.mg_member_list();
	}

	@Override
	public MemberVO loginMemberByGoogle(MemberVO vo) {
		return dao.loginMemberByGoogle(vo);
	}

	@Override
	public void joinMemberByGoogle(MemberVO vo) {
		dao.joinMemberByGoogle(vo);
		
	}

}
