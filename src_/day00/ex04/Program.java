package day00.ex04;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String data = in.nextLine();

        if (data.length() == 0)
            return;
        char[] string = data.toCharArray();

        int cnt;
        int[] arr = new int[65535];
        if ((cnt = countNumOccurChars(data, arr, string)) == -999) {
            System.err.println("The maximum number of occurrences of one of the characters exceeds 999 units.");
            return;
        }

        int[] indexMax = new int[10];
        getIndexMaxTen(arr, indexMax, cnt);
        char[][] out = new char[11][10];
        fillOutputArray(arr, indexMax, out);
        outputData(arr, indexMax, out);
        in.close();
    }

    static int countNumOccurChars(String data, int[] arr, char[] string) {
        int cnt = 0;

        for (int i = 0; i < data.length(); i++){
            if (arr[string[i]] == 0)
                cnt++;
            arr[string[i]]++;
            if (arr[string[i]] > 999)
                return -999;
        }
        return cnt;
    }

    static void getIndexMaxTen(int[] origin, int[] res, int cnt) {
        for (int i = 0; i < res.length; i++)
            res[i] = -1;
        for (int i = 0; i < origin.length && cnt > 0; i++) {
            if (origin[i] > 0) {
                cnt--;
                compAndAdd(origin, res, i);
            }
        }
    }

    static void compAndAdd(int[] origin, int[] res, int i) {
        for (int j = 0; j < res.length; j++)
        {
            if (res[j] == -1){
                res[j] = i;
                break;
            }
            else if ((origin[res[j]] < origin[i]) ||
                    (origin[res[j]] == origin[i] &&
                            res[j] > i)) {
                int tmp = res[j];
                res[j] = i;
                i = tmp;
            }
        }
    }

    static void fillOutputArray(int[] arr, int[] indexMax, char[][] out) {
        float coef = (float) arr[indexMax[0]] / 10;
        for (int i = 0; i < 10; i++) {
            int cnt_ = 0;
            if (indexMax[i] != -1)
                cnt_ = (int)(arr[indexMax[i]] / coef);
            for (int j = 10; j > -1; j--) {
                if (cnt_ == 0)
                    out[j][i] = ' ';
                else {
                    out[j][i] = '#';
                    cnt_--;
                }
            }
        }
    }

    static void outputData(int[] arr, int[] indexMax, char[][] out) {

        for (int i = 0; i < 11; i++){
            for (int j = 0; j < 10; j++) {
                if (indexMax[j] == -1)
                    break;
                if (out[i][j] == ' ' && ((i + 1) == 11 || out[i+1][j] == '#'))
                    System.out.print(arr[indexMax[j]] + "\t");  //Вывод числа вхождений символа в голове столбца
                else
                    System.out.print(out[i][j] + "\t");
            }
            System.out.print("\n");
        }

        for (int i = 0; i < 10; i++) {
            if (indexMax[i] == -1)
                break;
            System.out.print((char) indexMax[i] + "\t");
        }
        System.out.print("\n");
    }
}
