package day01.ex03;

import java.util.UUID;

public  interface TransactionList {
	void add(Transaction transaction);
	void removeById(UUID uuid) throws TransactionNotFound;
	Transaction[] toArray();
}