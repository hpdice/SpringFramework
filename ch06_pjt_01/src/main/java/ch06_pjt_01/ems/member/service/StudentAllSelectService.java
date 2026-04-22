package ch06_pjt_01.ems.member.service;

// 전체 학생정보 반환 allSelect() 메소드 존재 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentAllSelectService {
	private StudentDao studentDao;
	
	@Autowired
	public StudentAllSelectService(@Qualifier("stdDao") StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	// 생성자에서 의존 객체를 자동 주입 할때는 매개변수에 Qualifier 부여 
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
}
