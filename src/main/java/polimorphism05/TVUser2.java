package polimorphism05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser2 {

	public static void main(String[] args) {
		


		//1. Spring 컨테이너를 구동 
		AbstractApplicationContext factory = 
					new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로 부터 필요한 객체를 Lookup 한다.   : DI (객체를 주입) 
		
		
		TV tv = (TV) factory.getBean("sonyTV"); 
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

	}

}
