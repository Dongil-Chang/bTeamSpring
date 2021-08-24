package contactus;

import java.util.List;

import org.springframework.stereotype.Component;

import common.PageVO;

@Component
public class ContactUsPage extends PageVO{
	private List<ContactUsVO> list;

	public List<ContactUsVO> getList() {
		return list;
	}

	public void setList(List<ContactUsVO> list) {
		this.list = list;
	}
	
}
