package day01.ex00;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //init Scanner
        Scanner sc = new Scanner(System.in);
        User currentUser = null;
        while (true)
            currentUser = Program.mainMenuPrompt(sc);
    }
}