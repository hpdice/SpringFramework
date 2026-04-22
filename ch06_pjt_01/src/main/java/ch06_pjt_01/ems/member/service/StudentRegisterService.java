package ch06_pjt_01.ems.member.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentRegisterService {
	
	private StudentDao studentDao;
	
	@Inject
	public StudentRegisterService(@Named("studentDao1") StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	// 객체 생성때부터 studentDao1을 가지고 생성 
	
	public void register(Student student) {
		if (verify(student.getsNum())) {
			studentDao.insert(student);
		} else {
			System.out.println("The student has already registered.");
		}
	}
	
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student == null ? true : false;
	}
}
