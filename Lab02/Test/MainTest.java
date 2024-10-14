import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainTest {

    @Test
    public void testSize() {
        List<String> names = new LinkedList<>(Arrays.asList("Kay", "Jay", "May", "Fay", "Mary", "John"));
        assertEquals(6, Main.size(names), "Size should be 6 for the list of 6 elements.");
    }

    @Test
    public void testContainsFound() {
        List<String> names = new LinkedList<>(Arrays.asList("Kay", "Jay", "May", "Fay", "Mary", "John"));
        // Capture the output
        assertOutputContains(() -> Main.contains(names, "May"), "There is a String like this: May");
    }

    @Test
    public void testContainsNotFound() {
        List<String> names = new LinkedList<>(Arrays.asList("Kay", "Jay", "May", "Fay", "Mary", "John"));
        // Capture the output
        assertOutputContains(() -> Main.contains(names, "Alice"), "There is NO String like this: Alice");
    }

    private void assertOutputContains(Runnable runnable, String contained) {
        // Store the original System.out
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the runnable which contains our method call
        runnable.run();

        // Restore original System.out
        System.setOut(originalOut);

        // Assert that the output contains the expected value
        String output = outputStream.toString().trim();
        assertTrue(output.contains(contained), "Output should contain: " + contained);
    }
}