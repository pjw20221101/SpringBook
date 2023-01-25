package polimorphism03;

public class TVUser {

	public static void main(String[] args) {
		
		//클라이언트 코드 블락 : 외부에서 객체를 생성해서 주입받을때 수정하지 않아도 됨. 
		BeanFactory factory = new BeanFactory(); 
		TV tv =  (TV) factory.getBean(args[0]);
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

	}

}
