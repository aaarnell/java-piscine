package edu.school21;

/**
 * По сути, Spring предлагает контейнер,часто называемый контекстом приложения Spring,
 * который создает компоненты приложения и  управляет ими. Эти компоненты, или
 * bean-компоненты, объединяются внутри контекста Spring, образуя полноценное приложение
 */

import edu.school21.printer.PrinterWithPrefixImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        PrinterWithPrefixImpl printer0 = applicationContext.getBean("printerUpper", PrinterWithPrefixImpl.class);
        printer0.setPrefix("Prefix ");
        printer0.print("Hello!");
    }
}