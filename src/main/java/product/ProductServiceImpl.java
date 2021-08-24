package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired private ProductDAO dao;
	
	@Override
	public void product_insert(ProductVO vo) {
		dao.product_insert(vo);
	}

	@Override
	public List<ProductVO> product_list() {
		return dao.product_list();
	}

	@Override
	public ProductPage product_list(ProductPage page) {
		return dao.product_list(page);
	}

	@Override
	public ProductVO product_detail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void product_update(ProductVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void product_delete(int id) {
		// TODO Auto-generated method stub

	}

}
