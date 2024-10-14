import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> names = new LinkedList<String>();

        names.add("Kay");
        names.add("Jay");
        names.add("May");
        names.add("Fay");
        names.add("Mary");
        names.add("John");

        System.out.println("Size using custom method: " + size(names));
        System.out.println("Size using built-in method: " + names.size());

        contains(names, "May");
    }

    public static int size(List<String> list) {
        int count = 0;
        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        return count;
    }

    public static void contains(List<String> list, String str) {
        ListIterator<String> iterator = list.listIterator();
        boolean found = false;

        while (iterator.hasNext()) {
            if (iterator.next().equals(str)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("There is a String like this: " + str);
        } else {
            System.out.println("There is NO String like this: " + str);
        }
    }
}