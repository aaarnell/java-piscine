//package day03.ex01;

public class Program {

	public static void main(String[] args) {
		ResourceLock lock = new ResourceLock();
		if (args.length != 1) {
        	System.out.println("Please enter --count=<number>");
        }
        else if (args[0].startsWith("--count=")) {
        	int count = Integer.parseInt(args[0].substring(8));
        	if (count < 1) {
        		System.out.println("Please enter a number greater than 1");
        }

		Hen hen = new Hen(count, lock);
		Egg egg = new Egg(count, lock);

		egg.start();
		hen.start();
	    }
    }
}
