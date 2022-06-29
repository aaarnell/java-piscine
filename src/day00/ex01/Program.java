package day00.ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
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
        while(i <= num / 2) {
            if (num % i == 0) {
                flag = false;
                break;
            }
            ++i;
        }
        --i;
        System.out.println(flag+" "+i);
    }
}