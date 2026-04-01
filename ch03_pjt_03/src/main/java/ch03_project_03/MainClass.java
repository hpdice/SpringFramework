package ch03_project_03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//Spring이 XML 파일을 읽고 필요한 객체들을 자동으로 생성
		
		CalAssembler calAssembler =
				ctx.getBean("calAssembler", CalAssembler.class);
		//getBean 호출로 Spring 컨테이너가 생성한 객체 반환 
		// 개발자는 생성한 객체를 사용하기만 하고 있음 -- IOC ( 제어의 역전 )
		calAssembler.assemble();
		
		ctx.close();
	}

}
