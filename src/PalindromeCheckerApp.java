import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "radar";

        // Use Stack-based strategy
        PalindromeStrategy stackStrategy = new StackStrategy();
        check(word, stackStrategy);

        // Use Deque-based strategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        check(word, dequeStrategy);

    }

    static void check(String word, PalindromeStrategy strategy) {
        if (strategy.isPalindrome(word)) {
            System.out.println("\"" + word + "\" is a Palindrome using " + strategy.getClass().getSimpleName());
        } else {
            System.out.println("\"" + word + "\" is not a Palindrome using " + strategy.getClass().getSimpleName());
        }
    }
}

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

// Stack-based implementation
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based implementation
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}