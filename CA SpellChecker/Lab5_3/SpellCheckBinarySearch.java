package Lab5_3;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SpellCheckBinarySearch {

    public static void main(String[] args) {
        try {

            List<String> dictionaryWords = new ArrayList<>(readDictionary("C:\\Users\\t00228949\\Desktop\\Lab5_3\\words_alpha.txt"));
            Collections.sort(dictionaryWords);

            Set<String> documentWords = readWords("C:\\Users\\t00228949\\Desktop\\Lab5_3\\uncle_toms_cabin.txt");

            int numberMisspelledWordsDocument = 0;
            for (String word : documentWords) {

                if (Collections.binarySearch(dictionaryWords, word) < 0) {

                    numberMisspelledWordsDocument++;
                    System.out.println(word);

                }
            }

            System.out.println("Number of misspelled words in Uncle Tom's Cabin: " + numberMisspelledWordsDocument);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    private static Set<String> readDictionary(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }

    public static Set<String> readWords(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }
}
