package ch04_pjt_01.ems.member.service;

// 전체 학생정보 반환 allSelect() 메소드 존재 
import java.util.Map;
import ch04_pjt_01.ems.member.Student;
import ch04_pjt_01.ems.member.dao.StudentDao;

public class StudentAllSelectService {
	private StudentDao studentDao;
	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
}
