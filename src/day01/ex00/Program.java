package day01.ex00;

import java.util.Scanner;

public class Program{
    public static void main(String[] args) {
        //init Scanner
        //Scanner sc = new Scanner(System.in);
        //init user
        User userSender = new User("John", 100);
        User userReceiver = new User("Tommy", 1000);
        //init transaction
        String category = "debit";
        Integer amount = 100;
        Transaction transaction = new Transaction();
        transaction.setCategory(category);
        transaction.setAmount(amount);
        //print transaction
        System.out.println(transaction.getSender().getName() + " -> "  + transaction.getRecipient().getName() + ", " + transaction.getAmount() + ", " + transaction.getCategory() + ", " + transaction.getUUID());
    }

    //public static User mainMenuPrompt(Scanner sc) {


}