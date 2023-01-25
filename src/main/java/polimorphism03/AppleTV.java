package polimorphism03;

public class AppleTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("AppleTV - 전원을 켭니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("AppleTV - 전원을 끕니다.");
	}
	@Override
	public void volumeUp() {
		System.out.println("AppleTV - 볼륨을 높입니다.");
	}
	@Override
	public void volumeDown() {
		System.out.println("AppleTV - 볼륨을 낮춥니다.");
	}

}
