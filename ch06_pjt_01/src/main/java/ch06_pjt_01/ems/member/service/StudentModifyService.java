package ch06_pjt_01.ems.member.service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;

import ch06_pjt_01.ems.member.Student;
import ch06_pjt_01.ems.member.dao.StudentDao;

public class StudentModifyService {
	
	@Inject
	@Named("studentDao1")
	// Named 속성으로 지정 가능 , 별명이 아닌 bean id 
	private StudentDao studentDao;
	
	public StudentModifyService() {
		System.out.println("Default Constructor");
	}
	// Inject의 경우에도 디폴트 생성자 필요 
	
	public StudentModifyService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public void modify(Student student) {
		if (verify(student.getsNum())) {
			studentDao.update(student);
		} else {
			System.out.println("Student information is available.");
		}
	}
	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}

}
