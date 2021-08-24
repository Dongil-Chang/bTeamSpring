package product;

import java.sql.Date;

public class ProductVO {
	
	private int no, product_reg_code, product_tb_code, product_cost, su;
	private String product_id, product_type, product_code, commcode, subcode, product_member, product_using;
	private Date booking_start, booking_end;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getProduct_using() {
		return product_using;
	}
	public void setProduct_using(String product_using) {
		this.product_using = product_using;
	}
	public int getProduct_reg_code() {
		return product_reg_code;
	}
	public void setProduct_reg_code(int product_reg_code) {
		this.product_reg_code = product_reg_code;
	}
	public int getProduct_tb_code() {
		return product_tb_code;
	}
	public void setProduct_tb_code(int product_tb_code) {
		this.product_tb_code = product_tb_code;
	}
	public int getProduct_cost() {
		return product_cost;
	}
	public void setProduct_cost(int product_cost) {
		this.product_cost = product_cost;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getCommcode() {
		return commcode;
	}
	public void setCommcode(String commcode) {
		this.commcode = commcode;
	}
	public String getSubcode() {
		return subcode;
	}
	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}
	public String getProduct_member() {
		return product_member;
	}
	public void setProduct_member(String product_member) {
		this.product_member = product_member;
	}
	public Date getBooking_start() {
		return booking_start;
	}
	public void setBooking_start(Date booking_start) {
		this.booking_start = booking_start;
	}
	public Date getBooking_end() {
		return booking_end;
	}
	public void setBooking_end(Date booking_end) {
		this.booking_end = booking_end;
	}
	
	
	
}
