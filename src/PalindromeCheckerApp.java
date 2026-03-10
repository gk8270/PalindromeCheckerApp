public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String phrase = "A man a plan a canal Panama";

        String normalized = phrase.replaceAll("\\s+", "").toLowerCase();

        if (isPalindrome(normalized)) {
            System.out.println("\"" + phrase + "\" is a Palindrome");
        } else {
            System.out.println("\"" + phrase + "\" is not a Palindrome");
        }

    }

    static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}