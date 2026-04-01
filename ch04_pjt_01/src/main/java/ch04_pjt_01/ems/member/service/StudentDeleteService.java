package ch04_pjt_01.ems.member.service;

// delete()를 통하여 학생 정보 삭제

import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentDeleteService {
	private StudentDao studentDao;
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
