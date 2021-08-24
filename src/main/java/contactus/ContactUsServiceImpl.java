package contactus;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Autowired private ContactUsDAO dao;
	
	@Override
	public void cu_insert(ContactUsVO vo) {
		dao.cu_insert(vo);
	}

	@Override
	public List<ContactUsVO> cu_list() {
		return dao.cu_list();
	}

	@Override
	public ContactUsVO cu_detail(int board_num) {
		return dao.cu_detail(board_num);
	}

	@Override
	public void cu_update(ContactUsVO vo) {
		dao.cu_update(vo);
	}

	@Override
	public void cu_delete(int board_num) {
		dao.cu_delete(board_num);
	}

	@Override
	public ContactUsPage cu_list(ContactUsPage page) {
		return dao.cu_list(page);
	}

	@Override
	public void cu_reply_update(ContactUsVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cu_read(int board_num) {
		dao.cu_read(board_num);
	}

	@Override
	public void cu_reply_insert(ContactUsVO vo) {
		dao.cu_reply_insert(vo);
	}

	@Override
	public ContactUsPage cu_list(HashMap<String, Object> map) {
		return dao.cu_list(map);
	}

}
