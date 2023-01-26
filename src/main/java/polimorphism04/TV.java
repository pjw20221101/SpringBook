package polimorphism04;

public interface TV {
	
	//메소드를 선언만 한다. 모든 메소드는 public abstract 가 생략 되어 있다. 선언부만 있고 구현부가 없는 메소드 
		//자식 클래스에서 메소드 오버라이딩을 사용해서 구현한 메소드를 정의 해서 사용. 
	public void powerOn() ;       
	public void powerOff() ; 
	public void volumeUp();
	public void volumeDown(); 

}
