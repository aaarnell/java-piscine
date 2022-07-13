package day01.ex03;

public class Program {
	public static void main(String[] args) {
		try {
			User userTommy = new User("Tommy", 2000);
			User userJohn = new User("John", 1000);
			// Create a transaction
			//Transaction transaction = Transaction.createTransaction(userTommy, userJohn, -100);
			Integer amount = 100;
			Transaction outcome = Transaction.createTransaction(userTommy, userJohn, -amount);
        	Transaction income = Transaction.createTransaction(userTommy, userJohn, amount);
			TransactionList transactionList = new TransactionLinkedList();
			//ссылка типа интерфейса TransactionList ссылается на новый объект типа TransactionLinkedList
			//add - добавляет транзакцию в список
			//две транзакции с разными ID
			transactionList.add(outcome);
			transactionList.add(income);
			System.out.println("Transaction list size: " + ((TransactionLinkedList) transactionList).getSize());
			transactionList.removeById(outcome.getUUID());
			transactionList.removeById(income.getUUID());

			System.out.println("Transaction: " + outcome.getUUID() + " " + "from "+ outcome.getSender().getName() + " " + "to "+ outcome.getRecipient().getName() + " " + "with "+ outcome.getCategory() + " " + outcome.getAmount());
			System.out.println("Transaction: " + income.getUUID() + " " + "from "+ income.getSender().getName() + " " + "to "+ income.getRecipient().getName() + " " + "with "+ income.getCategory() + " " + income.getAmount());
			System.out.println("Transaction list size after removal: " +((TransactionLinkedList) transactionList).getSize());

			System.out.println("After transaction: " + userTommy.getName() + " " + userTommy.getBalance());
        	System.out.println("After transaction: " + userJohn.getName() + " " + userJohn.getBalance());

		} catch (TransactionNotFound e) {
			System.out.println(e.getMessage());
		}
	}
}
