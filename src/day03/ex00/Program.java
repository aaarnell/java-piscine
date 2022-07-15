package day03.ex00;

public class Program {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please enter --count=<number>");
		} else if (args[0].startsWith("--count=")) {
			int count = Integer.parseInt(args[0].substring(8));
			if (count < 1) {
				System.out.println("Please enter a number greater than 1");
			}
		}
	}
}
