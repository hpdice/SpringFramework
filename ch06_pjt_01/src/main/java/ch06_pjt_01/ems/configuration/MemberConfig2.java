package ch06_pjt_01.ems.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
// 에너테이션을 이용한 스프링 설정 파일 명시
public class MemberConfig2 {

	@Bean
	public DBConnectionInfo dev_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("000.000.000.000");
		dbConnectionInfo.setUserId("admin");
		dbConnectionInfo.setUserPw("0000");

		return dbConnectionInfo;
	}

	/*
	 * <bean id="dev_DBConnectionInfoDev class="ch06_pjt_01.ems.member.DBConnectionInfo">
	 * 	<property name="url" value="000.000.000.000"/>
	 *  <property name="userId" value="admin"/>
	 *  <property name="userPw" value="0000"/>
	 * </bean>
	 */
	@Bean
	public DBConnectionInfo real_DBConnectionInfoDev() {
		DBConnectionInfo dbConnectionInfo = new DBConnectionInfo();
		dbConnectionInfo.setUrl("111.111.111.111");
		dbConnectionInfo.setUserId("master");
		dbConnectionInfo.setUserPw("1111");

		return dbConnectionInfo;
	}
}
