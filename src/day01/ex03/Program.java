package day01.ex03;

import day01.ex00.User;

public class Program {
	public static void main(String[] args) {
		try {
			User userTommy = new User("Tommy", 1000);
			User userJohn = new User("John", 200);
			System.out.println("\n======================TOMMY to JOHNY========================");

			System.out.println("Sender: " + userTommy.getName() + " with balance" + " " + userTommy.getBalance());
			System.out.println("Receiver: " + userJohn.getName() + " with balance" + " " + userJohn.getBalance());
			//init transaction
			Integer amount = 1001;
			day01.ex00.Transaction outcome = day01.ex00.Transaction.createTransaction(userTommy, userJohn, -amount);
			day01.ex00.Transaction income = day01.ex00.Transaction.createTransaction(userTommy, userJohn, amount);

			System.out.println("After transaction: " + userTommy.getName() + " " + userTommy.getBalance());
			System.out.println("After transaction: " + userJohn.getName() + " " + userJohn.getBalance());

			TransactionList transactionList = new TransactionLinkedList();

			transactionList.add(outcome);

			transactionList.removeById(outcome.getUUID());

			Transaction[] transactions = transactionList.toArray();
			System.out.println(transactions[0].getUUID());

		} catch (TransactionNotFound e) {
			System.out.println(e.getMessage());
		}
	}
}
