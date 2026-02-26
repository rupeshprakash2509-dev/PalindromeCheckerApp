import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Convert string to linked list
    private static Node stringToLinkedList(String input) {
        if (input.length() == 0) return null;

        Node head = new Node(input.charAt(0));
        Node current = head;

        for (int i = 1; i < input.length(); i++) {
            current.next = new Node(input.charAt(i));
            current = current.next;
        }

        return head;
    }

    // Reverse linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    // Check palindrome using linked list
    private static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Fast and slow pointers to find middle
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalfHead = reverse(slow);

        // Compare first and second half
        Node firstHalf = head;
        Node secondHalf = secondHalfHead;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        Node head = stringToLinkedList(input);

        boolean result = isPalindrome(head);

        if (result) {
            System.out.println("✅ The string is a Palindrome!");
        } else {
            System.out.println("❌ The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
