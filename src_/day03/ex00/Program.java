package day03.ex00;

public class Program {

	public static void main(String[] args) {
		if (args.length != 1) {
        	System.out.println("Please enter --count=<number>");
        }
        else if (args[0].startsWith("--count=")) {
        	int count = Integer.parseInt(args[0].substring(8));
        	if (count < 1) {
        		System.out.println("Please enter a number greater than 1");
        }

		Hen hen = new Hen("Hen", count);
		Egg egg = new Egg("Egg", count);

		try {
			egg.join();
			hen.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
        }
        for(int i = 0; i < count; i++)
            System.out.println("Human");
	    }
    }
}
