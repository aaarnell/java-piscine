package day03.ex00;

public class Egg {
	private int count;

	public Egg(int count) {
		this.count = count;
	}

	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println("Egg");
		}
	}
}
