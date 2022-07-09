package day01.ex00;

import java.util.Scanner;
//debit is all the money flowing INTO an account
//credit is all the money flowing OUT an account
public class Program{
    public static void main(String[] args) {
        //init Scanner
        //Scanner sc = new Scanner(System.in);
        //init user
        System.out.println("\n======================TOMMY'S CREDIT========================");
        User userTommy = new User("Tommy", 1000);
        System.out.println("User: " + userTommy.getName() + " " + userTommy.getBalance());
        //init transaction
        String category = "credit";
        Integer amount = -100;
        Transaction transaction = new Transaction();
        transaction.setCategory(category);
        transaction.setAmount(amount);
        userTommy.setBalance(userTommy.getBalance() + amount);
        //print transaction
        System.out.println("Transaction type: " + transaction.getCategory() + " " + transaction.getAmount());
        System.out.println("After transaction: " + userTommy.getName() + " " + userTommy.getBalance());
        System.out.println("\n=======================JOHNY'S DEBIT========================");
        User userJohn = new User("John", 200);
        System.out.println("Sender: " + userJohn.getName() + " " + userJohn.getBalance());
        category = "debit";
        amount = 200;
        transaction.setCategory(category);
        transaction.setAmount(amount);
        userJohn.setBalance(userJohn.getBalance() + amount);
        System.out.println("Transaction type: " + transaction.getCategory() + " " + transaction.getAmount());
        System.out.println("After transaction: " + userJohn.getName() + " " + userJohn.getBalance());

    }

    //public static User mainMenuPrompt(Scanner sc) {


}