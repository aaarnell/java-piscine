package day01.ex03;

public class Program {
	public static void main(String[] args) {
		try {
			User userTommy = new User("Tommy", 2000);
			User userJohn = new User("John", 1000);
			// Create a transaction
			Transaction transaction = Transaction.createTransaction(userTommy, userJohn, 100);
			TransactionList transactionList = new TransactionLinkedList();
			//ссылка типа интерфейса TransactionList ссылается на новый объект типа TransactionLinkedList
			//add - добавляет транзакцию в список
			transactionList.add(transaction);
			System.out.println("Transaction list size: " + ((TransactionLinkedList) transactionList).getSize());
			transactionList.removeById(transaction.getUUID());

			System.out.println("Transaction: " + transaction.getUUID() + " " + "from "+ transaction.getSender().getName() + " " + "to "+ transaction.getRecipient().getName() + " " + "with "+ transaction.getCategory() + " " + transaction.getAmount());
			System.out.println("Transaction list size after removal: " +((TransactionLinkedList) transactionList).getSize());

			System.out.println("After transaction: " + userTommy.getName() + " " + userTommy.getBalance());
        	System.out.println("After transaction: " + userJohn.getName() + " " + userJohn.getBalance());

		} catch (TransactionNotFound e) {
			System.out.println(e.getMessage());
		}
	}
}
