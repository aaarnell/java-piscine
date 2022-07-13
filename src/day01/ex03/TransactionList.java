package day01.ex03;

public class TransactionList {
	void add(Transaction transaction) throws TransactionNotFoundException;
	void removeById(UUID uuid) throws TransactionNotFoundException;
	public Transaction[] toArray();
}