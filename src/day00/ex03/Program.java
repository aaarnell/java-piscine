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
                break ;

            //дописать проверку на номер недели
            str.append(strOfWeek).append(" ");

            System.out.print("-> ");
            str.append(getMinFromLine(scan));
        }
        scan.close();
        System.out.println(str);
    }

    static String getMinFromLine(Scanner values){
        StringBuilder result = new StringBuilder(values.nextLine());
        //дописать проверку на количество значений
        //проверку на величину каждого значения не более 9

        values.useDelimiter(" |\\n");
     	int min = 10;
     	while(values.hasNext()){
 			int num = values.nextInt();
 			if(num < min)
 				min = num;
 		}
// 		int num;
// 		for (int i = 0; i < 5; ++i) {
// 			if(i == 4)
// 			{
// 				System.out.println("lastElem --> ");
// 				break;
// 			}
// 			else
// 				num = values.nextInt();
//
// 			if (num < min)
// 				min = num;
// 			System.out.println("----> "+num);
// 		}

// 		System.out.println("<----> ");
 		for(int i = 0; i < min; ++i)
             result.append("=");
// 		while(values.hasNext()){
//         	System.out.println(values.next());
//    		}
        result.append(">\n");
        //System.out.println("<<----> ");
        return result.toString();
    }
}