package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		/*
		 * TranspotationWalk transpotationWalk = new TranspotationWalk();
		 * transpotationWalk.move();
		 */

		// spring container에 접근
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		// container에있는 Bean(객체) 가져오기
		TranspotationWalk transpotationWalk = ctx.getBean("tWalk", TranspotationWalk.class);
		transpotationWalk.move();

		// resources 반환
		ctx.close();
		
	}

}
