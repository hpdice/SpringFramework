package ch06_pjt_01.ems.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentDeleteService {
	
	@Autowired
	@Qualifier("stdDao")
	private StudentDao studentDao;
	
	public StudentDeleteService() {
		System.out.println("Default Constructor");
	}
	// 생성자가 여러 개인 경우 필드에서 의존 객체를 자동 주입
	// 디폴트 생성자가 없으면 오류 발생 
	
	public StudentDeleteService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public void delete(String sNum) {
		if (verify(sNum)) {
			studentDao.delete(sNum);
		} else {
			System.out.println("Student information is available.");
		}
	}
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}

}
