package faq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqServiceImpl implements FaqService {

	@Autowired private FaqDAO dao;
	
	@Override
	public void faq_insert(FaqVO vo) {
		dao.faq_insert(vo);
	}

	@Override
	public List<FaqVO> faq_list() {
		return dao.faq_list();
	}

	@Override
	public FaqPage faq_list(FaqPage page) {
		return dao.faq_list(page);
	}

	@Override
	public FaqVO faq_detail(String faq_code) {
		return dao.faq_detail(faq_code);
	}

	@Override
	public void faq_update(FaqVO vo) {
		dao.faq_update(vo);
	}

	@Override
	public void faq_delete(String faq_code) {
		dao.faq_delete(faq_code);
	}

}
