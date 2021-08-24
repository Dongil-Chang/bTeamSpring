package faq;

public class FaqVO {

	private int no;
	private String faq_code, faq_title, faq_content, faq_regist_date;

	public String getFaq_code() {
		return faq_code;
	}

	public void setFaq_code(String faq_code) {
		this.faq_code = faq_code;
	}

	public String getFaq_title() {
		return faq_title;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}

	public String getFaq_content() {
		return faq_content;
	}

	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}

	public String getFaq_regist_date() {
		return faq_regist_date;
	}

	public void setFaq_regist_date(String faq_regist_date) {
		this.faq_regist_date = faq_regist_date;
	}
	
	
}
