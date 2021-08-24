package faq;

import java.util.List;



public interface FaqService {
	
//	FAQ 페이지 작업
	void faq_insert(FaqVO vo);			// Faq 저장 (C)
	List<FaqVO> faq_list();				// Faq 목록 조회(R)
	FaqPage faq_list(FaqPage page);		// Faq 페이지 처리 목록 조회(R)
	
	FaqVO faq_detail(String faq_code);	// Faq 상세 조회(R)
	void faq_update(FaqVO vo);			// Faq 내용 수정(U)
	void faq_delete(String faq_code);	// Faq 내용 삭제(D)
	
}