public class MainWithQueue {

    public static void main(String[] args) {
        CP3LinkedList<String> queue = new CP3LinkedList<>();

        // Add elements to the queue
        queue.addLast("Kay");
        queue.addLast("Jay");
        queue.addLast("May");
        queue.addLast("Fay");
        queue.addLast("Mary");
        queue.addLast("John");

        System.out.println("Size of the queue: " + queue.size());

        System.out.println("Removing: " + queue.removeFirst());
        System.out.println("Size after removal: " + queue.size());

    }
}