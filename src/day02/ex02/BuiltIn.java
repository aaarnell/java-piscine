package day02.ex02;

import java.nio.file.Path;

public class BuiltIn {
    public static void mv(Path path, String arg1, String arg2) {

    }

    public static void ls(Path path) {
        //получить список файлов path
        //создать строку типа "file\t88\tKB\n" для каждого
        //вывести в консоль
    }

    public static Path cd(Path path, String arg1) {
        StringBuilder res = new StringBuilder(path.toString());
        if(arg1.startsWith("../"))
        {
            res.append(path.toString().substring(0, path.toString().lastIndexOf('/'))).append(arg1.substring(2));
        }
        if(arg1.startsWith("./"))
        {
            res.append(path.toString().substring(0, path.toString().lastIndexOf('/'))).append(arg1.substring(2));
        }

        //проверить, корректна ли директория в arg1
        //если корректна, изменим path

        return path;
    }
}
