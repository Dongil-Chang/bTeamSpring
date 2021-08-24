package product;

import java.util.List;

public interface ProductService {

	void product_insert(ProductVO vo);			// 상품 신규 저장(C)
	
	List<ProductVO> product_list();				// 상품 목록 조회(R)
	ProductPage product_list(ProductPage page);	// 상품 목록 조회 -페이징 (R)
	ProductVO product_detail(int id);			// 상품 상세 조회(R)
	void product_update(ProductVO vo);			// 상품 변경 저장(U)
	
	void product_delete(int id);				// 공지글 삭제 (D)
	
	
}
