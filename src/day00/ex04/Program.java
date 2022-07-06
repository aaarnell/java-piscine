package day00.ex04;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        int[] arr = new int[65535];
        int cnt = 0;
        char[] string = data.toCharArray();
        for (int i = 0; i < data.length(); i++){
            if (arr[string[i]] == 0)
               cnt++;
            arr[string[i]]++;
        }
        //найти максимальное значение 10 максимальных значений
        int[] indexMax = new int[10];
        getIndexMaxTen(arr, indexMax, cnt);

        for (int i = 0; i < indexMax.length && indexMax[i] != -1; i++)
            System.out.println("Index_" + indexMax[i] + ": " + (char) indexMax[i] + " = " + arr[indexMax[i]]);
    }

    static void getIndexMaxTen(int[] origin, int[] res, int cnt){
        for (int i = 0; i < res.length; i++)
            res[i] = -1;
        for (int i = 0; i < origin.length && cnt > 0; i++) {
            if (origin[i] > 0) {
                cnt--;
                compAndAdd(origin, res, i);
            }
        }
    }

    static void compAndAdd(int[] origin, int[] res, int i){
        for (int j = 0; j < res.length; j++)
        {
            if (res[j] == -1){
                res[j] = i;
                break;
            }
            else if ((origin[res[j]] < origin[i]) ||
            (origin[res[j]] == origin[i] &&
            origin[res[j]] > origin[i])) {
                int tmp = res[j];
                res[j] = i;
                i = tmp;
            }
        }
    }
}