package day01.ex00;

import java.util.Scanner;

public class Program{
    public static void main(String[] args) {
        //init Scanner
        //Scanner sc = new Scanner(System.in);
        //init user
        User userSender = new User("John", 200);
        System.out.println("Sender: " + userSender.getName() + " " + userSender.getBalance());
        User userReceiver = new User("Tommy", 1000);
        System.out.println("Receiver: " + userReceiver.getName() + " " + userReceiver.getBalance());
        //init transaction
        String category = "debit";
        Integer amount = 100;
        Transaction transaction = new Transaction();
        transaction.setCategory(category);
        transaction.setAmount(amount);
        //print transaction
        System.out.println("Transaction: " + transaction.getCategory() + " " + transaction.getAmount());
    }

    //public static User mainMenuPrompt(Scanner sc) {


}