package day01.ex03;

import java.util.UUID;

class TransactionNotFound extends Exception {
	public TransactionNotFound(String message) {
		super(message);
	}
}

public class TransactionLinkedList implements TransactionList {

	private transactionNode first;

	private transactionNode last;

	private int size;

	/**
	 * @param first first element of the list
	 * @param last last element of the list
	 * @param size number of elements in the list
	 */

	public TransactionLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
		
		first = new transactionNode(null, null, null);
		last = new transactionNode(null, null, null);
		first.setNext(last);
		last.setPrev(first);
	}

	// Add a transaction to the list
	public void add(Transaction transaction) {
		first.setNext(new transactionNode(transaction, first, null));
		size++;
	}

	//removeById - remove transaction by id
	public void removeById(UUID uuid) throws TransactionNotFound {
		transactionNode current = first;
		transactionNode previous = null;
		while (current != null) {
			if (current.getTransaction().getUUID().equals(uuid)) {
				if (previous == null) {
					first = current.getNext();
				} else {
					previous.setNext(current.getNext());
				}
				size--;
				return;
			}
			previous = current;
			current = current.getNext();
		}
		throw new TransactionNotFound("Transaction not found");
	}

	/**
	 * @return array of transactions
	 */

	public Transaction[] toArray() {
		Transaction[] transactions = new Transaction[size];
		transactionNode current = first.getNext();
		int i = 0;
		while (current != null) {
			transactions[i] = current.getTransaction();
			current = current.getNext();
			i++;
		}
		return transactions;
	}

	private static class transactionNode {
		private Transaction transaction;
		private transactionNode next;
		private transactionNode prev;

		/**
		 * @param transaction transaction data
		 * @param next pointer to next transaction
		 * @param prev pointer to previous transaction
		 */

		public transactionNode(Transaction transaction, transactionNode next, transactionNode prev) {
			this.transaction = transaction;
			this.next = next;
			this.prev = prev;
		}

		//get transaction data
		public Transaction getTransaction() {
			return transaction;
		}

		//get next transaction
		public transactionNode getNext() {
			return next;
		}

		//get previous transaction
		public transactionNode getPrev() {
			return prev;
		}

		//set next transaction
		public void setTransaction(Transaction transaction) {
			this.transaction = transaction;
		}
		//set next transaction
		public void setNext(transactionNode next) {
			this.next = next;
		}
		//set previous transaction
		public void setPrev(transactionNode prev) {
			this.prev = prev;
		}
	}
}
