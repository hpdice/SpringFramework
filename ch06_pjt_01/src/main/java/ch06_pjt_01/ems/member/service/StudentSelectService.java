package ch06_pjt_01.ems.member.service;

import javax.annotation.Resource;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentSelectService {

	@Resource(name="studentDao1")
	// 별명 아닌 bean id 
	private StudentDao studentDao;
	
	public StudentSelectService() {
		System.out.println("Default Constructor");
	}

	public StudentSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public Student select(String sNum) {
		if (verify(sNum)) {
			return studentDao.select(sNum);
		} else {
			System.out.println("Student information is not available.");
		}
		return null;
	}
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}
}
