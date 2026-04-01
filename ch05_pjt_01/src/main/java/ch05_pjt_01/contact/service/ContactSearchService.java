package ch05_pjt_01.contact.service;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ContactSearchService {
	
	
	// 필드에 Autowired 적용하여 의존 객체 자동 주입 
//	@Autowired 
	
	@Resource(name="contactDao1")
	// 빈 이름으로도 주입 가능
	private ContactDao contactDao;
	
	public ContactSearchService() {
		System.out.println("default constructor");
	}
	
//	@Autowired // 객체 생성시 데이터 타입 검색 후 알맞은 객체 주입
//	public ContactSearchService(ContactDao contactDao) {
//		
//		System.out.println("contactDao : " + contactDao); //contactDao 자동 주입 확인
//		
//		this.contactDao = contactDao;
//	}
	
	public ContactSet searchContact(String name) {
		if (verify(name)) {
			return contactDao.select(name);
		} else {
			System.out.println("Contact information is available.");
		}
		return null;
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet != null ? true : false;
	}
	
	public void setContactDao
	(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
}
