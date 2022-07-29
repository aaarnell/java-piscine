package edu.app;

import edu.classes.*;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, InvocationTargetException {

        List<Class<?>> classes = ClassFinder.find("edu.classes");
        System.out.println("Classes:");
        for (Class one : classes) {
            System.out.println(new StringBuilder("\t-\t").append(one.getSimpleName()));
        }
        System.out.println("--------------------");

        System.out.print("Enter class name:\n-> ");
        Scanner scan = new Scanner(System.in);
        String className = scan.nextLine();

        //Создаем объект класса
        Class clazz = Class.forName("edu.classes." + className);

        System.out.println("--------------------");

        //Получить поля класса, и вывести их
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("fields:");
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(
                    new StringBuilder("\t\t")
                    .append(field.getType().getSimpleName()).append(" ")
                    .append(field.getName())
            );
        }

        //Получить методы класса, и вывести их
        Method[] methods = clazz.getMethods();
        Map<String, Method> mapMethods = new HashMap<String, Method> ();
        System.out.println("methods:");
        for (Method method : methods) {
            if (method.getDeclaringClass() == clazz && !method.getName().equals("toString")) {
                method.setAccessible(true);
                StringBuilder protoMethod = new StringBuilder()
                        .append(method.getName()).append("(");
                int i = 0;
                for (Class param : method.getParameterTypes()) {
                    if(i++ != 0) {
                        protoMethod.append(",");
                    }
                    protoMethod.append(param.getSimpleName());
                }
                protoMethod.append(")");
                mapMethods.put(protoMethod.toString(), method);
                System.out.println(new StringBuilder("\t\t")
                        .append(method.getReturnType().getSimpleName()).append(" ")
                        .append(protoMethod));
            }
        }

        System.out.println("--------------------");

        System.out.println("Let's create an object");
        Object clazzObject = clazz.newInstance();   //создаем экземпляр класса дефолтным конструктором

        //здесь будет цикл по получению значений для полей
        for (Field field : fields) {
            System.out.print(new StringBuilder(field.getName()).append(":\n-> "));
            setValueToField(clazzObject, field, scan.nextLine());
        }

        System.out.println("Object created: " + clazzObject);

        System.out.println("--------------------");

        System.out.print("Enter name of the field for changing:\n-> ");
        Field fieldToChange = clazz.getDeclaredField(scan.nextLine());
        fieldToChange.setAccessible(true);

        System.out.print("Enter " + fieldToChange.getType().getSimpleName() + " value:\n-> ");
        setValueToField(clazzObject, fieldToChange, scan.nextLine());

        System.out.println("Object update: " + clazzObject);

        System.out.println("--------------------");

        System.out.print("Enter name of the method for call:\n-> ");
        Method methodToRun = mapMethods.get(scan.nextLine());

        //здесь цикл по получению аргументов метода
        List<Object> params = new ArrayList<Object>();
        for (Class param : methodToRun.getParameterTypes()) {
            String type = param.getSimpleName();
            System.out.print(new StringBuilder("Enter ").append(type).append(" value:\n-> "));
            String value = scan.nextLine();
            if (type.equals("String")) {
                params.add(value);
            } else if (type.equals("Integer") || type.equals("int")) {
                params.add(Integer.parseInt(value));
            } else if (type.equals("Double") || type.equals("double")) {
                params.add(Double.parseDouble(value));
            } else if (type.equals("Boolean") || type.equals("boolean")) {
                params.add(Boolean.parseBoolean(value));
            } else if (type.equals("Long") || type.equals("long")) {
                params.add(Long.parseLong(value));
            }
        }

        //Здесь выполнение метода
        try {
            Object res = methodToRun.invoke(clazzObject, params.toArray());
            System.out.println("Method returned:\n" + res.toString());
        } catch (NullPointerException ignored) {}

    }

    public static void setValueToField(Object obj, Field field, String value) throws IllegalAccessException {
        String type = field.getType().getSimpleName();
        if (type.equals("String")) {
            field.set(obj, value);
        } else if (type.equals("Integer")) {
            field.set(obj, Integer.parseInt(value));
        } else if (type.equals("Double")) {
            field.set(obj, Double.parseDouble(value));
        } else if (type.equals("Boolean")) {
            field.set(obj, Boolean.parseBoolean(value));
        } else if (type.equals("Long")) {
            field.set(obj, Long.parseLong(value));
        }
    }
    public static class ClassFinder {
        private static final char PKG_SEPARATOR = '.';

        private static final char DIR_SEPARATOR = '/';

        private static final String CLASS_FILE_SUFFIX = ".class";

        private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

        public static List<Class<?>> find(String scannedPackage) {
            String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
            URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
            if (scannedUrl == null) {
                throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
            }
            File scannedDir = new File(scannedUrl.getFile());
            List<Class<?>> classes = new ArrayList<>();
            for (File file : scannedDir.listFiles()) {
                classes.addAll(find(file, scannedPackage));
            }
            return classes;
        }

        private static List<Class<?>> find(File file, String scannedPackage) {
            List<Class<?>> classes = new ArrayList<>();
            String resource = scannedPackage + PKG_SEPARATOR + file.getName();
            if (file.isDirectory()) {
                for (File child : file.listFiles()) {
                    classes.addAll(find(child, resource));
                }
            } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
                int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
                String className = resource.substring(0, endIndex);
                try {
                    classes.add(Class.forName(className));
                } catch (ClassNotFoundException ignore) {
                }
            }
            return classes;
        }
    }
}
