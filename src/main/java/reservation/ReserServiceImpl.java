package reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserServiceImpl implements ReserService {
	
	@Autowired private ReserDAO dao;


	@Override
	public List<ReserVO> mg_reser_list() {
		return dao.mg_reser_list();
	}

	@Override
	public List<ReserVO> reser_list() {
		return dao.reser_list();
	}

	@Override
	public boolean reser_insert(ReserVO vo) {
		return dao.reser_insert(vo);
	}

}
