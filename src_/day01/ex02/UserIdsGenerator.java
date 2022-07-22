package day01.ex02;

public class UserIdsGenerator {
    private static final UserIdsGenerator INSTANCE = new UserIdsGenerator();

   	private int uuid = 1;

   	private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance(){
    	return  INSTANCE;
	}

	public int generateId(){
		return this.uuid++;
	}
}
