package day01.ex02;

public class Program{
    public static void main(String[] args) {

    	UsersArrayList usersList = new UsersArrayList();

        usersList.add(new User("Simon", 100));
        usersList.add(new User("Andrew", 200));
        usersList.add(new User("James", 300));
        usersList.add(new User("John", 400));
        usersList.add(new User("Philip", 500));
        usersList.add(new User("Bartholomew", 600));
        usersList.add(new User("Matthew", 700));
        usersList.add(new User("Judas", 800));
        usersList.add(new User("Thomas", 900));
        usersList.add(new User( "Luke", 1000));
        usersList.add(new User("Zealot", 1100));
        usersList.add(new User("Solomon", 1200));
        usersList.add(new User("Paul", 1300));
        usersList.add(new User("Peter", 1400));

		System.out.println("======GET BY ID======");
		System.out.println(usersList.getByID(1));
		System.out.println(usersList.getByID(2));
		System.out.println(usersList.getByID(3));

		System.out.println("======GET BY INDEX======");
		System.out.println(usersList.getByIndex(0));
		System.out.println(usersList.getByIndex(1));
		System.out.println(usersList.getByIndex(2));
		System.out.println(usersList.getByIndex(3));
		System.out.println(usersList.getByIndex(4));

		System.out.println("======SIZE======");
		System.out.println(usersList.size());

	}

}
