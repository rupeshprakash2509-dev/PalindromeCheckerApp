import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        // Create Deque
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));  // insert at rear
        }

        boolean isPalindrome = true;

        // Remove first & last and compare
        while (deque.size() > 1) {
            char front = deque.removeFirst(); // from front
            char rear = deque.removeLast();   // from rear

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println("✅ The string is a Palindrome!");
        } else {
            System.out.println("❌ The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}