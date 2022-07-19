package day00.ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder str = new StringBuilder("");
        for (int i = 1; i <= 18; ++i)
        {
            System.out.print("-> ");
            String strOfWeek = scan.nextLine();
            if (strOfWeek.equals("42"))
                break;
            if (!strOfWeek.equals("Week " + i))
            {
                System.err.println("IllegalArgument");
                System.exit(-1);;
            }
            System.out.print("-> ");
            String arrow = getArrow(scan.nextLine());
            if (arrow.equals("null"))
            {
                System.err.println("Incorrect test data");
                return;
            }
            str.append(strOfWeek).append(" ").append(arrow);
        }
        scan.close();
        System.out.println(str);
    }

    static String getArrow(String numbers){
        int min = 10;
        int cnt = 0;
        Scanner nums = new Scanner(numbers);
        while (nums.hasNext())
        {
            cnt++;
            int num = nums.nextInt();
            if (cnt > 5 || num < 1 || num > 9)
                return "null";
            if (num < min)
                min = num;
        }
        nums.close();
        if (cnt != 5)
            return "null";
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < min; i++)
            result.append("=");
        result.append(">\n");
        return result.toString();
    }
}