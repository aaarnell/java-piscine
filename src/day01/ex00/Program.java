package day01.ex00;

//debit is all the money flowing INTO an account
//credit is all the money flowing OUT an account
public class Program{
    public static void main(String[] args) {
        User userTommy = new User("Tommy", 1000);
        User userJohn = new User("John", 200);
        System.out.println("\n======================TOMMY to JOHNY========================");

        System.out.println("Sender: " + userTommy.getName() + " with balance" + " " + userTommy.getBalance());
        System.out.println("Receiver: " + userJohn.getName() + " with balance" + " " + userJohn.getBalance());
        //init transaction
        String category = "credit";
        Integer amount = -100;
        Transaction transaction = new Transaction();
        transaction.setCategory(category);
        transaction.setAmount(amount);

        userTommy.setBalance(userTommy.getBalance() + amount);
        userJohn.setBalance(userJohn.getBalance() + (-amount));

        System.out.println("Transaction type: " + transaction.getCategory() + " " + transaction.getAmount());
        System.out.println("After transaction: " + userTommy.getName() + " " + userTommy.getBalance());
        System.out.println("After transaction: " + userJohn.getName() + " " + userJohn.getBalance());
        System.out.println("\n======================JOHNY to TOMMY========================");

        System.out.println("Receiver: " + userTommy.getName() + " with balance" + " " + userTommy.getBalance());
        System.out.println("Sender: " + userJohn.getName() + " with balance" + " " + userJohn.getBalance());
        category = "debit";
        amount = 200;
        transaction.setCategory(category);
        transaction.setAmount(amount);

        userJohn.setBalance(userJohn.getBalance() + (-amount));
        userTommy.setBalance(userTommy.getBalance() + amount);

        System.out.println("Transaction type: " + transaction.getCategory() + " " + transaction.getAmount());
        System.out.println("After transaction: " + userTommy.getName() + " " + userTommy.getBalance());
        System.out.println("After transaction: " + userJohn.getName() + " " + userJohn.getBalance());

    }
}