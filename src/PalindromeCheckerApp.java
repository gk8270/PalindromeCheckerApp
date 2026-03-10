import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "amanaplanacanalpanama";

        long start, end;

        start = System.nanoTime();
        boolean stackResult = stackPalindrome(word);
        end = System.nanoTime();
        System.out.println("Stack Approach: " + stackResult + " | Time: " + (end - start) + " ns");

        start = System.nanoTime();
        boolean dequeResult = dequePalindrome(word);
        end = System.nanoTime();
        System.out.println("Deque Approach: " + dequeResult + " | Time: " + (end - start) + " ns");

        start = System.nanoTime();
        boolean twoPointerResult = twoPointerPalindrome(word);
        end = System.nanoTime();
        System.out.println("Two-Pointer Approach: " + twoPointerResult + " | Time: " + (end - start) + " ns");
    }

    static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }

    static boolean dequePalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    static boolean twoPointerPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

