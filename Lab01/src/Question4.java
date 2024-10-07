import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Question4 {

    public static void main(String[] args) {

        Map<String, HashSet<Integer>> wordLineMap = new HashMap<>();

        String fileName = "C:/Users/t00228949/Desktop/hamlet.txt";

        try {
            Scanner scanner = new Scanner(new File(fileName));
            int lineNumber = 1;

            while (scanner.hasNextLine()) {
                Scanner lineParser = new Scanner(scanner.nextLine());
                lineParser.useDelimiter("[^A-Za-z0-9]+");

                while (lineParser.hasNext()) {
                    String word = lineParser.next();

                    wordLineMap.putIfAbsent(word, new HashSet<>());

                    wordLineMap.get(word).add(lineNumber);
                }

                lineNumber++;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Iterator<Map.Entry<String, HashSet<Integer>>> iterator = wordLineMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, HashSet<Integer>> entry = iterator.next();
            System.out.println("Word: " + entry.getKey() + ", Lines: " + entry.getValue());
        }
    }
}