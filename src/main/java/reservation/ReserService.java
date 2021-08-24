package reservation;

import java.util.List;



public interface ReserService {
	
	List<ReserVO> mg_reser_list();    // 관리자용 예약목록 조회(안드로이드)
	List<ReserVO> reser_list();  	  // 예약목록 조회(안드로이드)
	boolean reser_insert(ReserVO vo); // 예약추가
	
	
}
