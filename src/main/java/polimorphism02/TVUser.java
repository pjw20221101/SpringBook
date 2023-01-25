package polimorphism02;

public class TVUser {

	public static void main(String[] args) {

		//처음에는 SamsungTV 사용 ==> LgTV로 변경시 유지 보수가 어떻게 쉬운지 확인 
		
		//SamsungTV tv = new SamsungTV(); 
		//LgTV tv = new LgTV();
		
		//TV tv = new SamsungTV(); 
		TV tv = new LgTV(); 
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
			

	}

}
