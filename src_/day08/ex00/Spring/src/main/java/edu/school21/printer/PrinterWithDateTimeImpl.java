package edu.school21.printer;

public class PrinterWithDateTimeImpl implements Printer {

    public void print(String input) {
        System.out.println(input);
    }

    public void printWithDateTime(String input) {
        System.out.println(input);
    }

    public void printWithDateTime(String input, String dateTime) {
        System.out.println(input + " " + dateTime);
    }
}
