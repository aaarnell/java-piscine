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
        Integer amount = 1001;
        Transaction outcome = Transaction.createTransaction(userTommy, userJohn, -amount);
        Transaction income = Transaction.createTransaction(userTommy, userJohn, amount);
        if (outcome != null && income != null)
        {
            System.out.println("After transaction: " + userTommy.getName() + " " + userTommy.getBalance());
            System.out.println("After transaction: " + userJohn.getName() + " " + userJohn.getBalance());
        }
    }
}