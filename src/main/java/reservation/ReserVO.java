package reservation;

public class ReserVO {
	private String  product_id, product_type, booking_member, booking_start, booking_end ,product_using;

	
	public ReserVO() {}


	public ReserVO(String product_id, String product_type, String booking_member, String booking_start,
			String booking_end, String product_using) {
		super();
		this.product_id = product_id;
		this.product_type = product_type;
		this.booking_member = booking_member;
		this.booking_start = booking_start;
		this.booking_end = booking_end;
		this.product_using = product_using;
	}


	public ReserVO(String product_id, String product_type, String booking_start, String booking_end) {
		super();
		this.product_id = product_id;
		this.product_type = product_type;
		this.booking_start = booking_start;
		this.booking_end = booking_end;
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


	public String getBooking_member() {
		return booking_member;
	}


	public void setBooking_member(String booking_member) {
		this.booking_member = booking_member;
	}


	public String getBooking_start() {
		return booking_start;
	}


	public void setBooking_start(String booking_start) {
		this.booking_start = booking_start;
	}


	public String getBooking_end() {
		return booking_end;
	}


	public void setBooking_end(String booking_end) {
		this.booking_end = booking_end;
	}


	public String getProduct_using() {
		return product_using;
	}


	public void setProduct_using(String product_using) {
		this.product_using = product_using;
	}

	
	
	
}
