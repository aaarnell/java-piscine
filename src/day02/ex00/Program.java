package day02.ex00;

import java.io.*;
import java.util.*;

// 		try(FileInputStream fis = new FileInputStream("src/day02/ex00/input.txt");
// 				FileOutputStream fos = new FileOutputStream("src/day02/ex00/result.txt");

/**
 *
 */

//read from file

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
				System.out.println(name + " " + signature);//print the name and signature
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
