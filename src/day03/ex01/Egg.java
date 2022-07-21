package day03.ex01;

public class Egg extends Thread {
	final ResourceLock lock;
	private int count;

	public Egg(int count, ResourceLock lock) {
		this.lock = lock;
		this.count = count;
	}

	public void run() {
		try{
			synchronized (lock){
				for (int i = 0; i < count; i++) {
					while (lock.flag != 1) {
						lock.wait();
					}
					System.out.println("Egg");
					Thread.sleep(100);
					lock.flag = 2;
					lock.notify();
				}
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
