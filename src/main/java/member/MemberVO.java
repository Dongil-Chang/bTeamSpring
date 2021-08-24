package member;

public class MemberVO {
	private String member_code, id, pw, name, email, addr, tel, birth, naver, kakao, 
		commcode, subcode, social_email, social_type, booking;
	private int no;
	
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public MemberVO() {}
	
	
	public String getBooking() {
		return booking;
	}

	public void setBooking(String booking) {
		this.booking = booking;
	}

	public String getSocial_email() {
		return social_email;
	}



	public void setSocial_email(String social_email) {
		this.social_email = social_email;
	}



	public String getSocial_type() {
		return social_type;
	}



	public void setSocial_type(String social_type) {
		this.social_type = social_type;
	}



	public MemberVO(String id, String pw, String name, String email, String tel) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.tel = tel;
	}

		

	public String getMember_code() {
		return member_code;
	}

	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}



	public String getNaver() {
		return naver;
	}


	public void setNaver(String naver) {
		this.naver = naver;
	}


	public String getKakao() {
		return kakao;
	}


	public void setKakao(String kakao) {
		this.kakao = kakao;
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
	
	
}
