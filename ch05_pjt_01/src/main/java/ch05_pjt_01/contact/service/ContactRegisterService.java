package ch05_pjt_01.contact.service;

import ch05_pjt_01.contact.ContactSet;
import ch05_pjt_01.contact.dao.ContactDao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ContactRegisterService {
 
//	@Autowired
	// 필드에 Autowired 주입
	// 생성자나 Setter 없이 주입 가능
	
	@Autowired(required=false)
	// 의존 객체 자동 주입을 필수가 아닌 필요로 설정 
	@Resource
	// ContactDao를 필드에 자동 주입
	@Qualifier("usedDao")
	// Qualifier에는 Autowired,Resource 어느쪽을 사용해도 상관 없음
 	private ContactDao contactDao;

// 	@Autowired
 	// 메소드에 Autowired 주입
 	// 선택적 주입 가능 , 가독성이 좋고 변경 용이
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
 	
 	
//	@Autowired
 	// 단일 생성자일 경우에는 Autowired 생략 가능
	public ContactRegisterService(ContactDao contactDao) {
		System.out.println("contactDao : " + contactDao);
		
		this.contactDao = contactDao;
	}
	
 // @Autowired 
 	// 생성자가 여러개일 때는 Autowired가 붙은 생성자만 객체로 사용 
	// 명확하게 하나만 지정할것
	public ContactRegisterService() { // 디폴트 생성자
		System.out.println("default constructor");
	}
	
	// NullPointerException 발생 
	public void register(ContactSet contactSet) {
		String name = contactSet.getName();
		if (verify(name)) {
			contactDao.insert(contactSet);
		} else {
			System.out.println("The name has already registered.");
		}
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null ? true : false;
	}
	
		
}
