package day00.ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= 18; ++i) {
            System.out.print("-> ");
            Scanner week = new Scanner(System.in);
            String strOfWeek = week.nextLine();
            if (strOfWeek.equals("42")) {
                System.out.println(str);
                return;
            }
            str.append(strOfWeek).append(" ").append('\n');
        }
        System.out.println(str);
    }
}
