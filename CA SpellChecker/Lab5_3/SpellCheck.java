package Lab5_3;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SpellCheck {

   public static void main(String[] args) {
      try {
         // Uncomment one of the following lines to choose the desired collection class

         //Set<String> dictionaryWords = new LinkedHashSet<>(readDictionary("C:\\Users\\t00228949\\Desktop\\Lab5_3\\words_alpha.txt"));
         //Set<String> dictionaryWords = new TreeSet<>(readDictionary("C:\\Users\\t00228949\\Desktop\\Lab5_3\\words_alpha.txt"));
         //List<String> dictionaryWords = new ArrayList<>(readDictionary("C:\\Users\\t00228949\\Desktop\\Lab5_3\\words_alpha.txt"));
         //List<String> dictionaryWords = new LinkedList<>(readDictionary("C:\\Users\\t00228949\\Desktop\\Lab5_3\\words_alpha.txt"));
         Set<String> dictionaryWords = new HashSet<>(readDictionary("C:\\Users\\t00228949\\Desktop\\Lab5_3\\words_alpha.txt"));

         Set<String> documentWords = readWords("C:\\Users\\t00228949\\Desktop\\Lab5_3\\uncle_toms_cabin.txt");

         int numberMisspelledWordsDocument = 0;
         for (String word : documentWords) {
            if (!dictionaryWords.contains(word)) {
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