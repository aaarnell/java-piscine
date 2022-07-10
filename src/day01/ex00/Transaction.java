package day01.ex00;

import java.util.UUID;

public class Transaction {
    private UUID uuid;

    private User recipient;

    private User sender;

    private String category;

    private Integer amount;

    /**
     * @param UUID the unique identifier of the transaction
     * @param recipient user who received the transaction
     * @param sender user who sent the transaction
     * @param category category of the transaction
     * @param amount amount of the transaction
     */

    {
        this.uuid = UUID.randomUUID();
    }
    Transaction () {}

    Transaction (User recipient, User sender, String category, Integer amount){
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
        this.amount  = amount;
    }

    public UUID getUUID(){
        return this.uuid;
    }

    public void setUUID(UUID uuid){
        this.uuid = uuid;
    }

    public User getRecipient(){
        return this.recipient;
    }

    public void setRecipient(User recipient){
        this.recipient = recipient;
    }

    public User getSender(){
        return this.sender;
    }

    public void setSender(User sender){
        this.sender = sender;
    }

    public String getCategory(){ return this.category; }

    public void setCategory(String category){
        if(!category.equals("debit") && !category.equals("credit"))
            System.err.println("Use 'debit' or 'credit' please");
        this.category = category;
    }

    public Integer getAmount(){ return this.amount; }

    public void setAmount(Integer amount){
        if(amount < 0 && category.equals("debit"))
            System.err.println("Amount cannot be negative!");
        else if(amount > 0 && category.equals("credit"))
            System.err.println("Amount cannot be positive!");
        else
            this.amount = amount;
    }
}