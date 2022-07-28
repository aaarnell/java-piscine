package edu.school21.printer;

public class PrinterWithPrefixImpl implements Printer {
    private String prefix;

    public PrinterWithPrefixImpl(String prefix) {
        this.prefix = prefix;
    }

    public void print(String text) {
        System.out.println(prefix + text);
    }
}

