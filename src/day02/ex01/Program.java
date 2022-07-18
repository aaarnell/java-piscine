package day02.ex01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Program {

    private static class Values {

        private int val1;
        private int val2;

        private Values(int v1, int v2) {
            this.val1 = v1;
            this.val2 = v2;
        }

        public void updateValues(int v1, int v2) {
            this.val1 = v1;
            this.val2 = v2;
        }
    }// end of class Values

    public double score(String text1, String text2) {
        //Определите отдельные слова из обоих документов
        //разбить текст1 на слова и получить массив слов

        String[] text1Words = text1.split(" ");
        String[] text2Words = text2.split(" ");
        Map<String, Values> wordFreqVector = new HashMap<>();// word, (val1, val2)
        List<String> distinctWords = new ArrayList<>();//отдельные слова из обоих документов

        //подготовить вектор частоты слов с помощью Text1
        for (String text : text1Words) {//для каждого слова из текста1
            String word = text.trim();
            if (!word.isEmpty()) {
                if (wordFreqVector.containsKey(word)) {//если слово уже находится в wordFreqVector
                    Values vals1 = wordFreqVector.get(word); //получить значения для слова
                    int freq1 = vals1.val1 + 1;//увеличить частоту слова на 1
                    int freq2 = vals1.val2;//сохранить одинаковую частоту слова в тексте2
                    vals1.updateValues(freq1, freq2);//обновить значения слова в wordFreqVector
                    wordFreqVector.put(word, vals1);//обновить wordFreqVector
                } else {
                    Values vals1 = new Values(1, 0);//создать новые значения для слова в wordFreqVector
                    wordFreqVector.put(word, vals1);//добавить слово в wordFreqVector
                    distinctWords.add(word);//добавить слово в distinctWords
                }
            }
        }

        //подготовить вектор частоты слов с помощью Text2
        for (String text : text2Words) {
            String word = text.trim();
            if (!word.isEmpty()) {
                if (wordFreqVector.containsKey(word)) {
                    Values vals1 = wordFreqVector.get(word);
                    int freq1 = vals1.val1;
                    int freq2 = vals1.val2 + 1;
                    vals1.updateValues(freq1, freq2);
                    wordFreqVector.put(word, vals1);
                } else {
                    Values vals1 = new Values(0, 1);
                    wordFreqVector.put(word, vals1);
                    distinctWords.add(word);
                }
            }
        }

        //calculate the cosine similarity score.
        double vectAB = 0.0000000;
        double vectA = 0.0000000;
        double vectB = 0.0000000;
        for (int i = 0; i < distinctWords.size(); i++) { //для каждого слова из distinctWords
            Values vals12 = wordFreqVector.get(distinctWords.get(i)); //получить значения для слова
            double freq1 = vals12.val1;
            double freq2 = vals12.val2;
            //System.out.println(distinctWords.get(i) + "#" + freq1 + "#" + freq2);
            vectAB = vectAB + freq1 * freq2;
            vectA = vectA + freq1 * freq1;
            vectB = vectB + freq2 * freq2;
        }
        //System.out.println("VectAB " + vectAB + " VectA_Sq " + vectA + " VectB_Sq " + vectB);
        return ((vectAB) / (Math.sqrt(vectA) * Math.sqrt(vectB)));//вычисляем косинусную меру сходства
    }

    public static void main(String[] args) throws IOException {
        Program cs = new Program();//создать объект класса Program

        String text1 = Files.readAllLines(Paths.get("/Users/wrickard/Desktop/java-piscine/src/day02/ex01/fileA.txt")).stream().collect(Collectors.joining(" "));//получить текст из файла fileA.txt
        String text2 = Files.readAllLines(Paths.get("/Users/wrickard/Desktop/java-piscine/src/day02/ex01/fileB.txt")).stream().collect(Collectors.joining(" "));

        double score = cs.score(text1, text2);//вычислить косинусную меру сходства
        System.out.println("Cosine similarity score = " + score);
    }
}


