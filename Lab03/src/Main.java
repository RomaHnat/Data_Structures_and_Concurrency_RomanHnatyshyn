import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String expression1 = "( a + b * { c / ( d – e )} ) + [ d / e]";
        String expression2 = "( a + b * ( c / ( d – e ) ) + ( d / e )";

        System.out.println("Expression 1 is balanced: " + isBalanced(expression1));
        System.out.println("Expression 2 is balanced: " + isBalanced(expression2));
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        boolean balanced = true;
        int index = 0;

        while (balanced && index < expression.length()) {
            char ch = expression.charAt(index);

            if (isOpen(ch)) {
                stack.push(ch);
            } else if (isClose(ch)) {
                if (stack.isEmpty()) {
                    balanced = false;
                } else {
                    char topChar = stack.pop();
                    if (!areMatching(topChar, ch)) {
                        balanced = false;
                    }
                }
            }
            index++;
        }

        return balanced && stack.isEmpty();
    }

    private static boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[' || ch == '<';
    }

    private static boolean isClose(char ch) {
        return ch == ')' || ch == '}' || ch == ']' || ch == '>';
    }

    private static boolean areMatching(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
                (c1 == '{' && c2 == '}') ||
                (c1 == '[' && c2 == ']') ||
                (c1 == '<' && c2 == '>');
    }
}