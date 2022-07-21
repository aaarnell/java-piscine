package day03.ex00;

public class Egg extends Thread {
	private int count;

	Egg(String name, int count){
		super(name);
		this.count = count;
		this.start();
	}

	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.println(getName());
		}
	}
}
