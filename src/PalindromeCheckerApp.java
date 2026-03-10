public class PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;
        Node(char data) { this.data = data; }
    }

    public static void main(String[] args) {

        String word = "madam";
        Node head = buildLinkedList(word);

        if (isPalindrome(head)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }

    }

    static Node buildLinkedList(String word) {
        Node head = null;
        Node tail = null;
        for (int i = 0; i < word.length(); i++) {
            Node node = new Node(word.charAt(i));
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        // Find middle using fast and slow pointers
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow.next);

        // Compare first half and reversed second half
        Node firstHalf = head;
        Node tempSecond = secondHalf;
        boolean isPalin = true;
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        return isPalin;
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}