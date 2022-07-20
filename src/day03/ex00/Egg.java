//package day03.ex00;

public class Egg extends Thread {
	private int count;

	public void EggThread(int count) {
		this.count = count;
	}

	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println("Egg");
		}
	}
}
