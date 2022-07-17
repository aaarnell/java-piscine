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

	public TransactionLinkedList() {
		this.size = 0;
		first = null;
		last = null;
	}

	// Add a transaction to the list
	public void add(Transaction transaction) {
		if(size == 0){
			first = new transactionNode(transaction, null, null);
			last = first;
		} else {
			last.next = new transactionNode(transaction, null, last);
			last = last.next;
		}
		size++;
	}



	//removeById - remove transaction by id
	public void removeById(UUID uuid) throws TransactionNotFound {
		transactionNode current = first;
		transactionNode previous = null;
		while (current != null) {
			if (current.getTransaction().getUUID() == uuid) {
				if (current == first) {
					first = first.getNext();
					first.prev = null;
				} else if (current == last) {
					last = last.getPrev();
					last.next = null;
				} else {
					previous.setNext(current.getNext());
					current.getNext().setPrev(previous);
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

	public int getSize() {
		return size;
	}

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
