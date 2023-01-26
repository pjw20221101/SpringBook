package polimorphism04;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SamsungTV - 전원을 켭니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 전원을 끕니다.");
	}
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV - 볼륨을 높입니다.");
	}
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV - 볼륨을 낮춥니다.");
	}
}
