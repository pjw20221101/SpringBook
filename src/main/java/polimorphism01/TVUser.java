package polimorphism01;

public class TVUser {

	public static void main(String[] args) {
		
		//강결합(결합도가 높다) : 유지 보수를 어렵게 하는 코드이다. 
			//1. 코드의 결합도를 느슨하게 해서 유지 보수를 쉽게 하는 코드
				// a. 인터페이스를 사용해서 구현한 객체에서 동일함 메소드 이름을 사용
				// b. 객체 생성을 개발자가 코드내부에서 생성것이 아니라 spring 프레임워크에게 위임 ( IoC )
						// 객체를 필요한 곳에 주입 ( DI ) 
						// Bean (객체) : 프레임워크에서 생성해서 주입 
		
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		System.out.println("======================");
		//TV 사용자가 Samsung TV에서 LgTV로 바꾸었다. 
		
		LgTV  tv2 = new LgTV(); 
		tv2.turnOn();
		tv2.turnOff();
		tv2.soundUp();
		tv2.soundDown();
		
		
		

	}

}
