import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> names = new LinkedList<String>();

        names.add("Kay");
        names.add("Jay");
        names.add("May");
        names.add("Fay");

        System.out.println(names);

        ListIterator<String> iterator = names.listIterator();

        iterator.next();
        iterator.next();
        iterator.next();

        iterator.add("Ray");


        System.out.println(names);

        iterator.previous();
        iterator.previous();
        iterator.previous();
        iterator.remove();

        System.out.println(names);

        iterator.previous();

        while (iterator.hasNext()) {

            System.out.println(iterator.next());

        }

        while (iterator.hasPrevious()) {

            System.out.println(iterator.previous());

        }

        names.add("Kay");

        System.out.println(names);

        HashSet<String> namesHash = new HashSet<>();

        namesHash.add("Kay");
        namesHash.add("Jay");
        namesHash.add("May");
        namesHash.add("Fay");
        namesHash.add("Kay");


        TreeSet<String> namesTree = new TreeSet<>();

        namesTree.add("Kay");
        namesTree.add("Jay");
        namesTree.add("May");
        namesTree.add("Fay");
        namesTree.add("Kay");

        Iterator<String> iterator3 = namesTree.iterator();
        Iterator<String> iterator2 = namesHash.iterator();

        while (iterator2.hasNext()) {

            System.out.println(iterator2.next());

        }

        System.out.println("\n");


        while (iterator3.hasNext()) {

            System.out.println(iterator3.next());

        }

        TreeSet<String> hamletTree = new TreeSet<>();

        String fileName = "C:/Users/t00228949/Desktop/hamlet.txt";

        try{

            Scanner scanner = new Scanner(new File(fileName));
            int lineNumber = 1;

            while (scanner.hasNextLine()) {

                Scanner lineParser = new Scanner(scanner.nextLine());

                lineParser.useDelimiter("[^A-Za-z0-9]+");

                while (lineParser.hasNext()) {

                    String word = lineParser.next();

                    hamletTree.add(word);

                }

                lineNumber++;

            }

        }catch (FileNotFoundException e) {

            System.out.println(e.getMessage());

        }

        Iterator<String> iterator4 = hamletTree.iterator();

        while (iterator4.hasNext()) {

            System.out.println(iterator4.next());

        }



    }

}
