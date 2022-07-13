package day01.ex03;

import day01.ex00.User;

public class Program {
	public static void main(String[] args) {
		try {
			day01.ex03.User userTommy = new day01.ex03.User("Tommy", 12345);
			day01.ex03.User userJohn = new day01.ex03.User("John", 12345);
			Transaction transaction = Transaction.createTransaction(userTommy, userJohn, 100);
			TransactionList transactionList = new TransactionLinkedList();
			transactionList.add(transaction);
			transactionList.removeById(transaction.getUUID());
			//init transaction
			Integer amount = 1001;
			transaction = Transaction.createTransaction(userTommy, userJohn, amount);
			System.out.println("Transaction: " + transaction.getUUID() + " " + transaction.getSender().getName() + " " + transaction.getRecipient().getName() + " " + transaction.getCategory() + " " + transaction.getAmount());
			//add transaction to list
			transactionList = new TransactionLinkedList();
			transactionList.add(transaction);
			//remove transaction from list
			transactionList.removeById(transaction.getUUID());

			Transaction[] transactions = transactionList.toArray();
			System.out.println(transactions[0].getUUID());

		} catch (TransactionNotFound e) {
			System.out.println(e.getMessage());
		}
	}
}
