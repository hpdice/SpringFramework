package ch04_pjt_01.ems.member.dao;

import java.util.HashMap;
import java.util.Map;
import ch04_pjt_01.ems.member.Student;

//데이터베이스 접속 , Service로 호출
//데이터의 insert,search,update,delete 등의 기능 수행
//HashMap으로 데이터 저장
//StudentDB 필드에 학생정보 저장
//key = sNum ( 학번 )

public class StudentDao {
	private Map<String, Student> studentDB = new HashMap<String, Student>();
	
	public void insert(Student student) {
	studentDB.put(student.getsNum(), student);
	}
	
	public Student select(String sNum) {
	return studentDB.get(sNum);
	}
	
	public void update(Student student) {
	studentDB.put(student.getsNum(), student);
	}

	public void delete(String sNum) {
		studentDB.remove(sNum);
	}
	
	public Map<String, Student> getStudentDB() {
		return studentDB;
	}


}
