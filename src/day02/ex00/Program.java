package day02.ex00;

import java.io.*;
import java.util.*;

// 		try(FileInputStream fis = new FileInputStream("src/day02/ex00/input.txt");
// 				FileOutputStream fos = new FileOutputStream("src/day02/ex00/result.txt");

/**
 *
 */

//read from file /Users/wrickard/Desktop/java-piscine/src/day02/ex00/signatures.txt

public class Program {
	public static void main(String[] args) {
		Map<String, String> signatures = new HashMap<>();//create a map to store the signatures

		try (Scanner scanner = new Scanner(new File("src/day02/ex00/signatures.txt"))) {//read from file
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(" ");//split the line into words
				String name = words[0];//get the name
				String signature = words[1];//get the signature
				signatures.put(name, signature);//put the name and signature into the map
				//System.out.println(name + " " + signature);//print the name and signature
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Scanner scan = new Scanner(System.in);//create a scanner to read from the console
		String path;

		int count = 0;//create a counter to count the number of signatures
		StringBuilder sb = new StringBuilder();//create a string builder to store the signatures
		while (scan.hasNext()) {
			sb = new StringBuilder();//create a new string builder to store the signatures
			path = scan.next();//get the path from the console
			if (path.equals("42")) {//if the path is end, break the loop
				break;
			}
			int maxCount = -1;
			try (FileInputStream fis = new FileInputStream(path);//create a file input stream to read from the file
				 FileOutputStream fos = new FileOutputStream("src/day02/ex00/result.txt")) {//create a file output stream to write to the file
				int b;
				while ((b = fis.read()) != -1) {//read from the file
					sb.append((char) b);//append the character to the string builder
				}
				String str = sb.toString();//convert the string builder to a string
				for (String key : signatures.keySet()) {//loop through the keys in the map
					int count1 = 0;//create a counter to count the number of times the signature appears in the string
					for (int i = 0; i < str.length(); i++) {//loop through the string
						if (str.charAt(i) == signatures.get(key).charAt(0)) {//if the character at the current index is the same as the first character of the signature
							count1++;//increment the counter
							if (count1 > maxCount) {//if the counter is greater than the max count
								maxCount = count1;//set the max count to the counter
							}
						}
					}
				}
				if (maxCount != -1) {//if the max count is not -1
					count++;//increment the counter
					fos.write(count);//write the counter to the file
					fos.write('\n');//write a new line to the file
					fos.write(path.getBytes());//write the path to the file
					fos.write('\n');//write a new line to the file
					fos.write(maxCount);//write the max count to the file
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
