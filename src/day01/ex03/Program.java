package day01.ex03;

public class Program {
	public static void main(String[] args) throws TransactionNotFound {
		User user1 = new User("John", 100);
		User user2 = new User("Jane", 200);

		Transaction transaction1 = Transaction.createTransaction(user1, user2, 50);
		Transaction transaction2 = Transaction.createTransaction(user1, user2, -50);
		Transaction transaction3 = Transaction.createTransaction(user1, user2, -50);
		Transaction transaction4 = Transaction.createTransaction(user1, user2, -50);

		TransactionLinkedList list = new TransactionLinkedList();
		list.add(transaction1);
		list.add(transaction2);
		list.add(transaction3);
		list.add(transaction4);

		System.out.println(list.toArray()[0].getUUID());
		System.out.println(list.toArray()[1].getUUID());
		System.out.println(list.toArray()[2].getUUID());
		System.out.println(list.toArray()[3].getUUID());

		list.removeById(transaction3.getUUID());
		System.out.println(list.toArray()[2].getUUID());

	}
}
