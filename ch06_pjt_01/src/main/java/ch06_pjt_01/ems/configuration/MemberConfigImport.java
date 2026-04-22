package ch06_pjt_01.ems.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ch06_pjt_01.ems.member.DBConnectionInfo;
import ch06_pjt_01.ems.member.dao.StudentDao;
import ch06_pjt_01.ems.member.service.EMSInformationService;
import ch06_pjt_01.ems.member.service.PrintStudentInformationService;
import ch06_pjt_01.ems.member.service.StudentAllSelectService;
import ch06_pjt_01.ems.member.service.StudentDeleteService;
import ch06_pjt_01.ems.member.service.StudentModifyService;
import ch06_pjt_01.ems.member.service.StudentRegisterService;
import ch06_pjt_01.ems.member.service.StudentSelectService;
import ch06_pjt_01.ems.utils.InitSampleData;

@Configuration
@Import({MemberConfig2.class,MemberConfig3.class})
// 임포트 태그로 다른 자바 파일 임포트
// 에너테이션을 이용한 스프링 설정 파일 명시
public class MemberConfigImport {

	@Bean
	public InitSampleData initSampleData() {
		InitSampleData initSampleData = new InitSampleData();
		String[] sNums = { "hbs001", "hbs002", "hbs003", "hbs004", "hbs005" };
		initSampleData.setsNums(sNums);
		String[] sIds = { "rabbit", "hippo", "raccoon", "elephant", "lion" };
		initSampleData.setsIds(sIds);
		String[] sPws = { "p0001", "p0002", "p0003", "p0004", "p0005" };
		initSampleData.setsPws(sPws);
		String[] sNames = { "agatha", "barbara", "chris", "doris", "elva" };
		initSampleData.setsNames(sNames);
		int[] sAges = { 19, 22, 20, 27, 19 };
		initSampleData.setsAges(sAges);
		char[] sGenders = { 'M', 'W', 'W', 'M', 'M' };
		initSampleData.setsGenders(sGenders);
		String[] sMajors = { "English", "Korean", "French", "Philosophy", "History" };
		initSampleData.setsMajors(sMajors);
		return initSampleData;
	}

	@Bean
	// 빈 객체를 생성하기 위한 에너테이션 
	public StudentDao studentDao() {
		return new StudentDao();
	}
	/*
	 * 다음 빈과 동일한 역할
	 * <bean id = "studentDao" class="ch06_pjt_01.ems.member.dao.StudentDao"/>
	 */

	@Bean
	public StudentRegisterService studentRegisterService() {
		return new StudentRegisterService(studentDao());
	}

	/*
	 * <bean id = "studentRegisterService" class = "ch06_pjt_01.ems.member.service.StudentRegisterService"/>
	 * 	<constructor-arg ref ="StudentDao" />
	 * 
	 */

	@Bean
	public StudentModifyService studentModifyService() {
		return new StudentModifyService(studentDao());
	}
	@Bean
	public StudentDeleteService studentDeleteService() {
		return new StudentDeleteService(studentDao());
	}
	@Bean
	public StudentSelectService studentSelectService() {
		return new StudentSelectService(studentDao());
	}
	@Bean
	public StudentAllSelectService studentAllSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	@Bean
	public PrintStudentInformationService printStudentInformationService() {
		return new PrintStudentInformationService(studentAllSelectService());
	}

}
