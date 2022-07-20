package day02.ex02;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class BuiltIn {
    public static void mv(Path path, String arg1, String arg2) {
        Path path1;
        Path path2;
        if (Paths.get(arg1).isAbsolute()){
            path1 = Paths.get(arg1);
        } else {
            path1 = Paths.get(path + "/" + arg1).normalize();
        }
        if (Paths.get(arg2).isAbsolute()){
            path2 = Paths.get(arg2);
        } else {
            path2 = Paths.get(path + "/" + arg2).normalize();
        }
        if (Files.isDirectory(path2)){
            path2 = Paths.get(path2 + "/" + path1.getFileName()) ;
        }
        try {
            Files.move(path1, path2);
        } catch (Exception e){
            System.out.println("Bad arguments");
        }
    }

    public static void ls(Path path) throws IOException {
        File file = new File(path.toString());
        for ( File f : file.listFiles() ){
            System.out.println(f.getName() + " " + Files.size(f.toPath()) + " KB");
        }
    }

    public static Path cd(Path path, String arg1) {
        Path path1 = Paths.get(arg1);
        if (path1.isAbsolute()){
            if (Files.isDirectory(path1) && Files.isReadable(path1)) {
                path = path1;
                System.out.println(path);
            }
            else {
                System.out.println(path);
                System.out.println("Is not directory!");
            }
        } else {
            if (Files.isDirectory(Paths.get(path + "/" + path1).normalize())
                    && Files.isReadable(Paths.get(path + "/" + path1).normalize())) {
                path = Paths.get(path + "/" + path1).normalize();
                System.out.println(path);
            }
            else {
                System.out.println(path + "/" + path1);
                System.out.println("Is not directory!");
            }
        }
        return path;
    }
}
