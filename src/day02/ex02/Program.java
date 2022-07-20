package day02.ex02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws Exception{

        //проверка на число аргументов. Должен быть 1 аргумент
        //проверка введенного значения аргумента
        if (args.length != 1 &&
                !args[0].startsWith("--current-folder=") &&
                !Files.isDirectory(Paths.get(args[0].substring(17)))) {
            System.err.println("Bad arguments");
            return;
        }
        Path path = Paths.get(args[0].substring(17));
        System.out.println(path.toString());

        Scanner input = new Scanner(System.in);
        while (true)
        {
            System.out.print("-> ");
            String[] cmd = input.nextLine().split(" ");
            if (cmd[0].equals("exit") && cmd.length == 1) {
                input.close();
                return;
            } else if (cmd[0].equals("mv")) {
                if (cmd.length != 3) {
                    System.out.println("Incorrect numbers of argument");
                    continue;
                }
                //выполнение комманды
                BuiltIn.mv(path, cmd[1], cmd[2]);
            } else if (cmd[0].equals("ls")) {
                //выполнение комманды
                BuiltIn.ls(path);
            } else if (cmd[0].equals("cd")) {
                //выполнение комманды с записью результата в path
                path = BuiltIn.cd(path, cmd[1]);
            } else {
                System.out.println("Unknown command");
            }
        }
	}
}
