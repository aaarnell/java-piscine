package day02.ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Program {

//	public static class lsCommand{
//
//	}
	public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "", "ls");
        Process p = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String readline;
        List<String> files = new ArrayList<String>();

        while ((readline = reader.readLine()) != null) {
            files.add(readline);
        }
	}
}
