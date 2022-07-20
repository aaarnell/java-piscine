package day03.ex02;

public class Program {
//max int in array is 1000
    public static void main(String[] args) throws Exception{

        if (args[0].startsWith("--arraySize=") && args[1].startsWith("--threadCount=")) {
        	int arraySize = Integer.parseInt(args[0].substring(12));
            int threadCount = Integer.parseInt(args[1].substring(15));
            } else {
				System.out.println("Please enter --arraySize=<number up to 2000000> and --threadCount=<number>");
			}

    }
}
