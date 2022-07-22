package day03.ex01;

public class Hen extends Thread {
	final ResourceLock lock;
	private int count;

	public Hen(int count, ResourceLock lock) {
		this.lock = lock;
		this.count = count;
	}

	public void run() {
		try{
			synchronized (lock){
			for (int i = 0; i < count; i++) {
				while (lock.flag != 2) {
					lock.wait();
				}
				System.out.println("Hen");
				Thread.sleep(100);
				lock.flag = 1;
				lock.notify();
				}
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}