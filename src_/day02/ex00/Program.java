package day02.ex00;

import java.io.*;
import java.util.*;

public class Program {
	public static void main(String[] args) throws IOException {
		Map<String, String> signatures = new HashMap<>();//create a map to store the signatures

		try {
			Scanner scanner = new Scanner(new File("src/day02/ex00/signatures.txt")); //read from file
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] words = line.split(", ");
				String name = words[0];
				String signature = words[1];
				signatures.put(signature, name);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder res = new StringBuilder();
		Scanner scan = new Scanner(System.in);//create a scanner to read from the console
		String path;
		FileOutputStream fos = new FileOutputStream("src/day02/ex00/result.txt");
		while (scan.hasNext()) {
			path = scan.next();
			if (path.equals("42")) {
				break;
			}
			try {
				StringBuilder sb = new StringBuilder();
				FileInputStream fis = new FileInputStream(path);
				for (int i = 0; i < 8; i++) {
					if (i > 0) {
						sb.append(' ');
					}
					String tmp = Integer.toHexString(fis.read());
					if (tmp.length() == 1) {
						sb.append('0');
					}
					sb.append(tmp.toUpperCase());
					if (signatures.containsKey(sb.toString())) {
						res.append(signatures.get(sb.toString()));
						fos.write(signatures.get(sb.toString()).getBytes());
						fos.write("\n".getBytes());
						break;
					}
				}
				System.out.println("PROCESSED");
			} catch (FileNotFoundException e) {
				System.out.println("UNDEFINED");
			}
		}
	}
}
