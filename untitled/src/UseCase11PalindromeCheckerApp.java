import java.util.Scanner;

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        // Create service object
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("✅ The string is a Palindrome!");
        } else {
            System.out.println("❌ The string is NOT a Palindrome.");
        }

        scanner.close();
    }
}

// Service class that encapsulates palindrome logic
class PalindromeChecker {

    // Exposed method
    public boolean checkPalindrome(String input) {

        if (input == null) return false;

        // Convert to char array (internal data structure)
        char[] characters = input.toCharArray();

        int start = 0;
        int end = characters.length - 1;

        // Two-pointer comparison
        while (start < end) {
            if (characters[start] != characters[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}