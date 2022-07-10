package day01.ex01;

//debit is all the money flowing INTO an account
//credit is all the money flowing OUT an account
public class Program{
    public static void main(String[] args) {

		User user = new User("John", 100);
		System.out.println(user.getUUID());
		user.setBalance(50);
		System.out.println(user.getBalance());

		User user1 = new User("Tommy", 200);
		System.out.println(user1.getUUID());
		user1.setBalance(150);
		System.out.println(user1.getBalance());
    }
}