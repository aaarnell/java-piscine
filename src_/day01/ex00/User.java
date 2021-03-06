package day01.ex00;

public class User {

    private String name;

    private Integer uuid;

    private Integer balance;

    /**
     * @param name the user's name
     * @param uuid the user's unique identifier
     * @param balance starting user's balance
     */

    public  User(String name, Integer balance){
        setName(name);
        setBalance(balance);

        //print log message
        System.out.println("User " + name + " created with balance " + balance);
    }

    public Integer getUUID(){
        return this.uuid;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getBalance(){
        return this.balance;
    }

    public void setBalance(Integer balance){
        if(balance > 0)
            this.balance = balance;
        else
            System.err.println("Balance cannot be negative!");
    }
}
