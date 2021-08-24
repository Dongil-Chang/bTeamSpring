package manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.MemberPage;
import member.MemberVO;

@Repository
public class ManagerDAO implements ManagerService {

	@Autowired private SqlSession sql; 
	
	@Override
	public List<MemberVO> member_list() {
		return sql.selectList("manager.mapper.member_list");
	}
	
	@Override
	public MemberPage member_list(MemberPage page) {
		page.setTotalList(sql.selectOne("manager.mapper.totalList", page) );  
		page.setList( sql.selectList("manager.mapper.list", page) );
		return page;
	}

	@Override
	public void provision_insert(ProvisionVO vo) {
		sql.insert("manager.mapper.provision_insert", vo);

	}

	@Override
	public List<ProvisionVO> provision_list() {
		return sql.selectList("manager.mapper.provision_list");
	}

	@Override
	public ProvisionVO provision_detail(String provision_code) {
		return sql.selectOne("manager.mapper.provision_detail", provision_code);
	}

	@Override
	public void provision_update(ProvisionVO vo) {
		sql.update("manager.mapper.provision_update", vo);
	}

	@Override
	public void provision_delete(String provision_code) {
		sql.delete("manager.mapper.provision_delete", provision_code);
	}


}
