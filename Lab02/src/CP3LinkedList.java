import java.util.NoSuchElementException;

class CP3LinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> last;
    private int size;

    public CP3LinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("The list is empty.");
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            last = null;
        }
        size--;
        return data; // Return the data
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}