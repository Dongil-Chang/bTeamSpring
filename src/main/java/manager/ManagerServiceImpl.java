package manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.MemberPage;
import member.MemberVO;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired private ManagerDAO dao;
	
	@Override
	public List<MemberVO> member_list() {
		return dao.member_list();
	}

	@Override
	public void provision_insert(ProvisionVO vo) {
		dao.provision_insert(vo);
	}

	@Override
	public List<ProvisionVO> provision_list() {
		return dao.provision_list();
	}

	@Override
	public ProvisionVO provision_detail(String provision_code) {
		return dao.provision_detail(provision_code);
	}

	@Override
	public void provision_update(ProvisionVO vo) {
		dao.provision_update(vo);
	}

	@Override
	public void provision_delete(String provision_code) {
		dao.provision_delete(provision_code);
	}

	@Override
	public MemberPage member_list(MemberPage page) {
		return dao.member_list(page);
	}


}
