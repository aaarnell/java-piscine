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
            //str.append(getArrow(scan.nextLine()));
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
        while (iEnd != -1 && iStart != str.length())          //дописать проверку на количество значений == 5
        {
            if(str.charAt(iStart) == ' '){
                iStart++;
                continue;
            }
            iEnd = str.indexOf(' ', iStart);
            if (iEnd == -1)
                num = Integer.parseInt(str.substring(iStart));          //дописать проверку на num == -1
            else
                num = Integer.parseInt(str.substring(iStart, iEnd));    //дописать проверку на num == -1
            //проверку на величину каждого значения не более 9
            if(num < 0 || num > 9)
                return -1;
            if (num < min)
                min = num;
            cnt++;
            iStart = iEnd + 1;
        }
        if(cnt != 5)
            return -1;
        //StringBuilder result = new StringBuilder();
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
    }
}