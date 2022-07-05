package day00.ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
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
            str.append(getArrow(scan.nextLine()));
        }
        scan.close();
        System.out.println(str);
    }

    static String getArrow(String str){
        //дописать проверку на пустую строку str.isEmpty();
        int iStart = 0;
        int iEnd = 0;
        int min = 10;
        int num;

        while (iEnd != -1 && iStart != str.length())          //дописать проверку на количество значений == 5
        {
            if(str.charAt(iStart) == ' '){
                iStart++;
                continue;
            }
            iEnd = str.indexOf(' ', iStart);
            //дописать проверку на iEnd == -1
            if (iEnd == -1)
                num = Integer.parseInt(str.substring(iStart));          //дописать проверку на num == -1
            else
                num = Integer.parseInt(str.substring(iStart, iEnd));    //дописать проверку на num == -1
            //проверку на величину каждого значения не более 9
            if (num < min)
                min = num;
            iStart = iEnd + 1;
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < min; ++i)
            result.append("=");
        result.append(">\n");
        return result.toString();
    }
}