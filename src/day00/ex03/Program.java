package day00.ex03;

import java.util.Scanner;

public class Program {
    /*public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 18; ++i) {
            System.out.print("-> ");
            String strOfWeek = scan.nextLine();
            if (strOfWeek.equals("42"))
                break;
            if (!strOfWeek.equals("Week " + i)) {
                System.err.println("IllegalArgument");
                return;
            }
            str.append(strOfWeek).append(" ");
            System.out.print("-> ");
            if(getArrow(scan.nextLine(), str) == -1){
                System.err.println("IncorrectInput");
                return;
            }
        }
        scan.close();
        System.out.println(str);
    }

    static int getArrow(String str, StringBuilder result){
        int iStart = 0;
        int iEnd = 0;
        int min = 10;
        int num;
        int cnt = 0;

        if (str.isEmpty() || checkStringNumOrSpace(str) == -1 || str.length() != 9)
            return -1;
        while (iEnd != -1 && iStart != str.length())
        {
            if(str.charAt(iStart) == ' '){
                iStart++;
                continue;
            }
            iEnd = str.indexOf(' ', iStart);
            if (iEnd == -1)
                num = Integer.parseInt(str.substring(iStart));
            else
                num = Integer.parseInt(str.substring(iStart, iEnd));
            if(num < 0 || num > 9)
                return -1;
            if (num < min)
                min = num;
            cnt++;
            iStart = iEnd + 1;
        }
        if(cnt != 5)
            return -1;
        for(int i = 0; i < min; ++i)
            result.append("=");
        result.append(">\n");
        return 0;
    }

    static int checkStringNumOrSpace(String s){
        for(int i=0; i < s.length(); i++)
            if((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != ' ')
                return -1;
        return 0;
    }*/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = "";
        for (int i = 1; i <= 18; ++i)
        {
            System.out.print("-> ");
            String strOfWeek = scan.nextLine();
            if (strOfWeek.equals("42"))
                break;
            if (!strOfWeek.equals("Week " + i))
            {
                System.err.println("Incorrect week data");
                return;
            }
            str += strOfWeek + " ";
            System.out.print("-> ");
            String arrow = getArrow(scan.nextLine());
            if (arrow.equals("null"))
            {
                System.err.println("Incorrect test data");
                return;
            }
            str += arrow;
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
        String result = "";
        for (int i = 0; i < min; i++)
            result += "=";
        result += ">\n";
        return result;
    }
}