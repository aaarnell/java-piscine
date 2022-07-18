package day03.ex00;

//public class Program implements Runnable {
//	volatile int i;
//	public void run() {
//		for (i = 0; i < 100; i++) {
//			System.out.println(i);
//		}
//	}
//
//	public static void main(String[] args) {
//		if (args.length == 0) {
//        	System.out.println("Please enter --count=<number>");
//        }
//        else if (args[0].startsWith("--count=")) {
//        	int count = Integer.parseInt(args[0].substring(8));
//        	if (count < 1) {
//        		System.out.println("Please enter a number greater than 1");
//        }
//		Program a = new Program();
//		Egg egg = new Egg(a);
//		Hen hen = new Hen(a);
//		egg.start();
//		hen.start();
//	}
//}
