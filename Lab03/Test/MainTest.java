import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testBalancedNestedParentheses() {
        assertTrue(Main.isBalanced("( a + b * { c / ( d – e )} ) + [ d / e ]"));
        assertTrue(Main.isBalanced("((2 + 3) * (4 - (5 + 6)))"));
        assertTrue(Main.isBalanced("(2 + [5 + 7] + 1)"));
    }

    @Test
    public void testBalancedDifferentTypes() {
        assertTrue(Main.isBalanced("(<a + b> * {c / [d – e]}) + {f}"));
        assertTrue(Main.isBalanced("{ [<a + b>] * (c) }"));
    }

    @Test
    public void testUnbalancedParentheses() {
        assertFalse(Main.isBalanced("( a + b * ( c / ( d – e ) ) + ( d / e )")); // Unbalanced
        assertFalse(Main.isBalanced("(<a + b> * {c / [d – e)} + {f}}")); // Mismatched
        assertFalse(Main.isBalanced("(a + b]")); // Mismatched
    }

    @Test
    public void testNoParentheses() {
        assertTrue(Main.isBalanced("a + b"));
        assertTrue(Main.isBalanced("5 + 7 - 3"));
        assertTrue(Main.isBalanced(""));
    }

    @Test
    public void testOnlyOpeningParentheses() {
        assertFalse(Main.isBalanced("(((("));
        assertFalse(Main.isBalanced("[{<("));
    }

    @Test
    public void testOnlyClosingParentheses() {
        assertFalse(Main.isBalanced("))))"));
        assertFalse(Main.isBalanced("}>)"));
    }
}