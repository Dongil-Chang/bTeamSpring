package contactus;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContactUsDAO implements ContactUsService {
	
	@Autowired private SqlSession sql;
	
	@Override
	public void cu_insert(ContactUsVO vo) {
		sql.insert("board.mapper.cu_insert", vo);
	}

	@Override
	public List<ContactUsVO> cu_list() {
		return sql.selectList("board.mapper.cu_list");
	}

	@Override
	public ContactUsVO cu_detail(int board_num) {
		return sql.selectOne("board.mapper.cu_detail", board_num);
	}

	@Override
	public void cu_update(ContactUsVO vo) {
		sql.update("board.mapper.cu_update", vo);
	}

	@Override
	public void cu_delete(int board_num) {
		sql.delete("board.mapper.cu_delete", board_num);
	}

	@Override
	public ContactUsPage cu_list(ContactUsPage page) {
		page.setTotalList(sql.selectOne("board.mapper.cu_totalList", page) );  
		page.setList( sql.selectList("board.mapper.cu_list", page) );
		return page;
	}

	@Override
	public void cu_reply_update(ContactUsVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cu_read(int board_num) {
		sql.selectOne("board.mapper.cu_read", board_num);
	}

	@Override
	public void cu_reply_insert(ContactUsVO vo) {
		sql.insert("board.mapper.cu_reply_insert", vo);
	}

	@Override
	public ContactUsPage cu_list(HashMap<String, Object> map) {
		ContactUsPage page = (ContactUsPage)map.get("page");
		page.setTotalList(sql.selectOne("board.mapper.cu_totalList", map) );  
		page.setList( sql.selectList("board.mapper.cu_list", map) );
		return page;
	}

}
