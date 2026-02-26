import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // Normalize string: remove spaces and convert to lowercase
    private static String normalize(String input) {
        // Remove all non-alphanumeric characters (including spaces) using regex
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "");
        return cleaned.toLowerCase();
    }

    // Palindrome check using two-pointer approach
    private static boolean isPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome (ignores spaces & case):");
        String input = scanner.nextLine();

        // Normalize string (ignore spaces & case)
        String normalized = normalize(input);

        boolean result = isPalindrome(normalized);

        if (result) {
            System.out.println("✅ The string IS a Palindrome (case & spaces ignored)!");
        } else {
            System.out.println("❌ The string is NOT a Palindrome (case & spaces ignored).");
        }

        scanner.close();
    }
}