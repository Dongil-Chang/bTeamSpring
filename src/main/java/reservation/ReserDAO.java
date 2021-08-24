package reservation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserDAO implements ReserService {

	@Autowired private SqlSession sql;

	@Override
	public List<ReserVO> mg_reser_list() {
		return sql.selectList("reser.mapper.mg_reserlist");
	}

	@Override
	public List<ReserVO> reser_list() {
		return sql.selectList("reser.mapper.reserlist");
	}

	@Override
	public boolean reser_insert(ReserVO vo) {
		return sql.insert("reser.mapper.reser_insert", vo) == 1 ? true : false;
	}

}
