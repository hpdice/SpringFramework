package ch04_pjt_02.scope;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		
		/* 
		 * 스프링은 싱글턴이기 때문에 동일한 객체 참조
		 * 
		 * Scope
		 * singleteon : getBean메소드는 동일한 빈을 반복 사용
		 * prototype : 싱글턴의 반대개념
		*/
		
		//dependencyBean에 prototype 명시 중
		DependencyBean dependencyBean_01 = ctx.getBean("dependencyBean",DependencyBean.class);
		DependencyBean dependencyBean_02 = ctx.getBean("dependencyBean",DependencyBean.class);
		
		if(dependencyBean_01.equals(dependencyBean_02)) {
			System.out.println("dependencyBean_01 == dependencyBean_02");
		}else {
			System.out.println("dependencyBean_01 != dependencyBean_02");
		}
		
		ctx.close();
	}

}
