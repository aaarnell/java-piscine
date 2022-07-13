package day01.ex03;

public abstract class TransactionList {
	abstract void add(Transaction transaction);
	abstract void removeById(UUID uuid);
	public abstract Transaction[] toArray();
}