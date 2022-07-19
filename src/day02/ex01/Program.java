import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Program {

    static long expectedSizeInMB = 10;
    static long expectedSizeInBytes = 1024 * 1024 * expectedSizeInMB;

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
    }

    public double score(String text1, String text2) {

        String[] text1Words = text1.split(" ");
        String[] text2Words = text2.split(" ");
        Map<String, Values> wordFreqVector = new HashMap<>();
        List<String> distinctWords = new ArrayList<>();

        for (String text : text1Words) {
            String word = text.trim();
            if (!word.isEmpty()) {
                if (wordFreqVector.containsKey(word)) {
                    Values vals1 = wordFreqVector.get(word);
                    int freq1 = vals1.val1 + 1;
                    int freq2 = vals1.val2;
                    vals1.updateValues(freq1, freq2);
                    wordFreqVector.put(word, vals1);
                } else {
                    Values vals1 = new Values(1, 0);
                    wordFreqVector.put(word, vals1);
                    distinctWords.add(word);
                }
            }
        }

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

        double vectAB = 0.0000000;
        double vectA = 0.0000000;
        double vectB = 0.0000000;
        for (int i = 0; i < distinctWords.size(); i++) {
            Values vals12 = wordFreqVector.get(distinctWords.get(i));
            double freq1 = vals12.val1;
            double freq2 = vals12.val2;

            vectAB = vectAB + freq1 * freq2;
            vectA = vectA + freq1 * freq1;
            vectB = vectB + freq2 * freq2;
        }
        return vectAB / (Math.sqrt(vectA) * Math.sqrt(vectB));
    }

    public static void main(String[] args) throws Exception {
        Program cs = new Program();
        if (args.length != 2)
            throw new Exception("Number of arguments greater than 2");
        try {
            long textAsizeInBytes = Files.size(Paths.get(args[0]));
            long textBsizeInBytes = Files.size(Paths.get(args[1]));

            if (textAsizeInBytes > expectedSizeInBytes || textBsizeInBytes > expectedSizeInBytes)
                System.out.println("File bigger than " + expectedSizeInMB + " MB");
            else {
                String text1 = String.join(" ", Files.readAllLines(Paths.get(args[0])));
                String text2 = String.join(" ", Files.readAllLines(Paths.get(args[1])));

                double score = cs.score(text1, text2);
                System.out.println("Similarity = " + (double)((long)(score * 100)) / 100);
            }
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }
}
