package day00.ex04;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        int[] arr = new int[data.length()];
        int i, j;

        char string[] = data.toCharArray();
        for (i = 0; i < data.length(); i++) {
            arr[i] = 1;
            for (j = i + 1; j < data.length(); j++) {
                if (string[i] == string[j]) {
                    arr[i]++;
                    string[j] = '\0';
                }
            }
        }
        System.out.println("Characters and their frequency in the string are:");
        for (i = 0; i < data.length(); i++) {
            if (string[i] != ' ' && string[i] != '\0') {
                System.out.println(string[i] + " : " + arr[i]);
            }
        }
    }
}