package day01.ex03;

public class TransactionLinkedList implements TransactionList {

	private Transaction first;

	private Transaction last;

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
	}

	public void add(Transaction transaction) throws TransactionNotFound{

	}

	public void removeById(UUID uuid) throws TransactionNotFound{


	}

	public Transaction[] toArray(){
		return null;
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

		public transactionNode getPrev() {
			return prev;
		}

		public void setTransaction(Transaction transaction) {
			this.transaction = transaction;
		}

		public void setNext(transactionNode next) {
			this.next = next;
		}

		public void setPrev(transactionNode prev) {
			this.prev = prev;
		}

		public String toString() {
			return transaction.toString();
		}

	}

}
