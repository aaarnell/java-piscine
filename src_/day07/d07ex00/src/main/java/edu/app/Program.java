package edu.app;

import edu.classes.Car;
import edu.classes.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        User user;
        Car car;
        String value;
        Scanner scan = new Scanner(System.in);
        System.out.println("Classes:");
        System.out.println("\t-\tUser");
        System.out.println("\t-\tCar");
        System.out.println("--------------------");

        System.out.print("Enter class name:\n-> ");
        String className = scan.nextLine();
        //Тут проверка на соответствие допустимым классам и прочим говнам во вводе

        //Создаем объект класса
        Class clazz = Class.forName(className);

        System.out.println("--------------------");

        //Получить поля класса, и вывести их
        Field[] fields = clazz.getClass().getDeclaredFields();
        System.out.println("fields:");
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println("\t\t" + field.toString());//field.getType() + " " + field.getName());
        }

        //Получить методы класса, и вывести их
        //Получить поля класса, и вывести их
        Method[] methods = clazz.getClass().getMethods();
        System.out.println("methods:");
        for (Method method : methods) {
            System.out.println("\t\t" + method.toString());
        }

        System.out.println("--------------------");
/*
        System.out.println("Let's create an object");
        Object clazzObject = clazz.newInstance();   //создаем экземпляр класса дефолтным конструктором

        //здесь будет цикл по получению значений для полей
            System.out.println("<fieldName>:\n-> "); //здесь вывести название поля и запросить ввод. Повторить для всех полей
            value = scan.nextLine(); //здесь тип получаемых данных зависит от типа поля

        //здесь создаем объект

        System.out.println("Object created: <classObject>.toString");

        System.out.println("--------------------");

        System.out.println("Enter name of the field for changing:\n-> ");
        value = scan.nextLine(); //здесь имя поля для изменения
        System.out.println("Enter <T> value:\n-> ");
        value = scan.nextLine(); //здесь значение поля для изменения

        //здесь меняем значение поля объекта

        System.out.println("Object update: <classObject>.toString");

        System.out.println("--------------------");

        System.out.println("Enter name of the method for call:\n-> ");
        value = scan.nextLine(); //здесь имя метода

        //здесь цикл по получению аргументам метода
            System.out.println("Enter <typeName> value:\n-> ");
            value = scan.nextLine(); //здесь значение аргумента

        //Здесь выполнение метода

        System.out.println("Method returned:\n");
        //Здесь вывод значения результата метода
*/
    }
}
