package day00.ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int cnt = 0;
        while(true){
            System.out.print("-> ");
            Scanner sc = new Scanner(System.in);
            int num;
            try {
                num = sc.nextInt();
                if (num < 2) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.err.println("IllegalArgument");
                return;
            }

            if (num == 42){
                System.out.println("Count of coffee-request - " + cnt);
                return;
            }

            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            boolean flag = true;
            for(int i = 2; i <= sum / 2; i++) {
                if (sum % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ++cnt;
        }
    }
}
