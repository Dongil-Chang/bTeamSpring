package contactus;

import java.util.HashMap;
import java.util.List;

public interface ContactUsService {
	void cu_insert(ContactUsVO vo); 		// 1:1 문의 신규 저장(C)
	List<ContactUsVO> cu_list();			// 1:1 문의 목록 조회(R)
	ContactUsVO cu_detail(int board_num);	// 1:1 문의 상세 내용 확인(R)
	void cu_update(ContactUsVO vo);			// 1:1 문의 내용 수정(U)
	void cu_delete(int board_num);			// 1:1 문의 내용 삭제(D)
	
	ContactUsPage cu_list(ContactUsPage page);	// 1:1 문의 목록 조회 - 페이지 처리 (R)
	ContactUsPage cu_list(HashMap<String, Object> map);	// 1:1 문의 목록 조회 - 페이지 처리 (R)
	
	
	void cu_reply_insert(ContactUsVO vo);	// 1:1 문의에 대한 답글 저장(C)
	void cu_reply_update(ContactUsVO vo);	// 1:1 문의에 대한 답글 변경 저장 (U)
	void cu_read(int board_num);			// 1:1 문의 조회시 조회수 증가 처리 (U)
}