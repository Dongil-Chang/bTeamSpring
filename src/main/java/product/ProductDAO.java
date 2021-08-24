package product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO implements ProductService {

	@Autowired private SqlSession sql;
	
	@Override
	public void product_insert(ProductVO vo) {
		sql.insert("product.mapper.insert", vo);
	}

	@Override
	public List<ProductVO> product_list() {
		return sql.selectList("product.mapper.list");
	}

	@Override
	public ProductPage product_list(ProductPage page) {
		page.setTotalList(sql.selectOne("product.mapper.totalList", page) );  
		page.setList( sql.selectList("product.mapper.list", page) );
		return page;
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
