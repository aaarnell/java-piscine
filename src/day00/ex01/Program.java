package day00.ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.print("-> ");
        Scanner sc = new Scanner(System.in);
        int num = 0;
        try {
            num = sc.nextInt();
            if (num < 2) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        boolean flag = true;
        int i = 2;
        for (; i * i <= num; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        System.out.println(flag + " " + (i - 1));
    }
}