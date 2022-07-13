package day01.ex03;

public class Program {
	public static void main(String[] args) {
		try {
			User userTommy = new User("Tommy", 12345);
			User userJohn = new User("John", 12345);
			Transaction transaction = Transaction.createTransaction(userTommy, userJohn, 100);
			TransactionList transactionList = new TransactionLinkedList();
			//ссылка типа интерфейса TransactionList ссылается на новый объект типа TransactionLinkedList
			transactionList.add(transaction);
			System.out.println(((TransactionLinkedList) transactionList).getSize());
			transactionList.removeById(transaction.getUUID());
			//init transaction
			Integer amount = 1001;
			transaction = Transaction.createTransaction(userTommy, userJohn, amount);
			System.out.println("Transaction: " + transaction.getUUID() + " " + transaction.getSender().getName() + " " + transaction.getRecipient().getName() + " " + transaction.getCategory() + " " + transaction.getAmount());
			System.out.println(((TransactionLinkedList) transactionList).getSize());
			//add transaction to list
//			transactionList = new TransactionLinkedList();
//			transactionList.add(transaction);
//			//remove transaction from list
//			transactionList.removeById(transaction.getUUID());

		} catch (TransactionNotFound e) {
			System.out.println(e.getMessage());
		}
	}
}
