package day01.ex03;

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
    Transaction (
            User sender,
            User recipient,
            String category,
            Integer amount
    ){
        this.sender = sender;
        this.recipient = recipient;
        this.category = category;
        this.amount  = amount;
        this.uuid = UUID.randomUUID();

        if (category.equals("credit"))
            sender.setBalance(sender.getBalance() + amount);
        else
            recipient.setBalance(recipient.getBalance() + amount);
    }

    public static Transaction createTransaction(
            User sender,
            User recipient,
            Integer amount
    ){
        if (amount > 0 && (sender.getBalance() - amount) >= 0)
            return new Transaction(sender, recipient, "debit", amount);
        else if (amount < 0 && (sender.getBalance() + amount) >= 0)
            return new Transaction(sender, recipient, "credit", amount);
        else {
            System.err.println("Transaction not created. Incorrect data of transaction.");
            return null;
        }
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