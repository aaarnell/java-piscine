package day03.ex00;

public class Hen {
	private int count;

	public Hen(int count) {
		this.count = count;
	}

	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println("Hen");
		}
	}
}
