package polimorphism04;

public class SonyTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SonyTV - 전원을 컵니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("SonyTV - 전원을 끕니다.");
	}
	@Override
	public void volumeUp() {
		System.out.println("SonyTV - 볼륨을 높입니다.");
	}
	@Override
	public void volumeDown() {
		System.out.println("SonyTV - 볼륨을 낮춥니다.");
	}
}
