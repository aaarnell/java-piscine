package day01.ex02;

/**
 * Интерфейс определяет контракт класса для реализации некоторого набора методов.
 * Чтобы написать класс, реализующий интерфейс, необходимо выполнить
 * два условия. Во-первых, в объявление класса должно быть включено ключевое
 * слово implements с именем интерфейса. Считайте это своего рода «подписью под
 * контрактом» — обязательством реализовать все абстрактные методы, объявленные
 * в интерфейсе. Во-вторых, вы должны реализовать каждый абстрактный метод.
 */

public class UsersArrayList implements UsersList {
	private User[] users;
	private int size;
	private int capacity;

	public UsersArrayList() {
		this.capacity = 10;
		this.users = new User[this.capacity];
		this.size = 0;
	}

	public void add(User user) {
		if (this.size == this.capacity) {
			User[] newUsers = new User[this.capacity * 2];
			for (int i = 0; i < this.size; i++) {
				newUsers[i] = this.users[i];
			}
			this.users = newUsers;
		}
		this.users[this.size] = user;
		this.size++;
	}

	/**
	 * super означает, что метод будет вызван из базового класса.
	 */
	public class UserNotFoundException extends Exception {
		public UserNotFoundException(String message) {
			super(message);
		}
	}
	public User getByIndex(int index) {
		if (index >= this.size) {
			throw new UserNotFoundException();
		}
		return this.users[index];
	}

	public User getByID(int id) {
		for (int i = 0; i < this.size; i++) {
			if (this.users[i].getId() == id) {
				return this.users[i];
			}
		}
		return null;
	}

	public int size() {
		return this.size;
	}
}
