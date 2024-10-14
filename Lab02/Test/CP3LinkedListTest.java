import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CP3LinkedListTest {

    private CP3LinkedList<String> queue;

    @BeforeEach
    public void setUp() {
        queue = new CP3LinkedList<>();
    }

    @Test
    public void testAddLast() {
        queue.addLast("Kay");
        queue.addLast("Jay");
        assertEquals(2, queue.size());
        assertEquals("Kay", queue.removeFirst()); // Check if "Kay" is removed first
        assertEquals("Jay", queue.removeFirst()); // Check if "Jay" is removed second
    }

    @Test
    public void testRemoveFirstFromEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.removeFirst();
        });
    }

    @Test
    public void testAddLastAndRemoveFirst() {
        queue.addLast("April");
        queue.addLast("May");
        queue.addLast("June");

        assertEquals(3, queue.size());
        assertEquals("April", queue.removeFirst());
        assertEquals(2, queue.size());

        assertEquals("May", queue.removeFirst());
        assertEquals(1, queue.size());

        assertEquals("June", queue.removeFirst());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.addLast("John");
        assertFalse(queue.isEmpty());

        queue.removeFirst();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());
        queue.addLast("Kay");
        assertEquals(1, queue.size());
        queue.addLast("Jay");
        assertEquals(2, queue.size());
        queue.removeFirst();
        assertEquals(1, queue.size());
    }
}