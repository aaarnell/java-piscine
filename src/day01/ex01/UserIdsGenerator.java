package day01.ex01;

public class UserIdsGenerator {
    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();

   	private int uuid = 0;

   	private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance(){
    	return  INSTANCE;
	}

	public static int generateId(){
		return INSTANCE.uuid++;
	}
}
