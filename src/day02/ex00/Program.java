package day02.ex00;

import java.io.*;
import java.util.*;

//read from file /Users/wrickard/Desktop/java-piscine/src/day02/ex00/signatures.txt
	///Users/wrickard/Desktop/java-piscine/src/day02/ex00/someshit.txt
	///Users/wrickard/Desktop/java-piscine/src/day02/ex00/screen.png
	//screen.png

public class Program {
	public static void main(String[] args) {
		Map<String, String> signatures = new HashMap<>();//create a map to store the signatures

		try {
			Scanner scanner = new Scanner(new File("src/day02/ex00/signatures.txt")); //read from file
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split("[ ,]+");//split the line into words
				String name = words[0];//get the name
				String signature = words[1];//get the signature
				signatures.put(name, signature);//put the name and signature into the map
				//System.out.println(name + " " + signature);//print the name and signature
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Scanner scan = new Scanner(System.in);//create a scanner to read from the console
		String path;
		StringBuilder sb = new StringBuilder();//create a string builder to store the signatures
		while (scan.hasNext()) {
			path = scan.next();//get the path from the console
			if (path.equals("42")) {//if the path is end, break the loop
				break;
			}
			int maxCount = -1;//create a max counter to store the max count of the signature
			try (FileInputStream fis = new FileInputStream(path);//create a file input stream to read from the file
				 FileOutputStream fos = new FileOutputStream("src/day02/ex00/result.txt")) {//create a file output stream to write to the file
 				int a;
 				while ((a = fis.read()) != -1) {//read from the file
 					sb.append((char) a);//append the character to the string builder
 				}
				String str = sb.toString();//convert the string builder to a string
				for (String key : signatures.keySet()) {//loop through the keys in the map
					int count1 = 0;//create a counter to count the number of times the signature appears in the string
					for (int i = 0; i < str.length(); i++) {//loop through the string
						if (str.charAt(i) == signatures.get(key).charAt(0)) {//if the character at the current index is the same as the first character of the signature
							count1++;//increment the counter
							if (count1 > maxCount) {//if the counter is greater than the max count
								maxCount = count1;//set the max count to the counter
								//удалить с 47 по 50
								//пройтись по строке с путем и забрать что после точки
								//потом сравнить это с сигнатурами в файле
							}
						}
					}
				}
				for(HashMap.Entry<String, String> entry : signatures.entrySet()) {//loop through the map
					String key = entry.getKey();//get the key
					//String value = entry.getValue();
					if(sb.toString().toUpperCase().startsWith(key)) {//if the string contains the key
						for (int i = 0; i < key.length(); i++) {//loop through the key
                        	fos.write(key.charAt(i));//write the character to the file
                        }
						System.out.println("PROCESSED");
                               break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
