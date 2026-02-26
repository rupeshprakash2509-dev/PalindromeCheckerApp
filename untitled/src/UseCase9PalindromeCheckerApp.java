import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {

    // Recursive method to check palindrome
    private static boolean isPalindrome(String input, int start, int end) {

        // Base condition: pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If characters at start and end do not match
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        // Recursive call with reduced problem size
        return isPalindrome(input, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("✅ The string is a Palindrome!");
        } else {
            System.out.println("❌ The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}