import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Never odd or even";  // test input (you can change this)

        // Normalize input for fair comparison (ignore spaces & case)
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("Input String       : " + input);
        System.out.println("Normalized String  : " + normalized);
        System.out.println();

        // Run and time different algorithms
        long start, end;

        start = System.nanoTime();
        boolean result1 = twoPointerPalindrome(normalized);
        end = System.nanoTime();
        long timeTwoPointer = end - start;

        start = System.nanoTime();
        boolean result2 = stackPalindrome(normalized);
        end = System.nanoTime();
        long timeStack = end - start;

        start = System.nanoTime();
        boolean result3 = dequePalindrome(normalized);
        end = System.nanoTime();
        long timeDeque = end - start;

        // Display results
        System.out.println("Algorithm Performance Comparison (ns)");
        System.out.println("-------------------------------------");
        System.out.println("Two-Pointer Approach : " + timeTwoPointer + " ns | Result: " + result1);
        System.out.println("Stack-Based Approach : " + timeStack + " ns | Result: " + result2);
        System.out.println("Deque-Based Approach : " + timeDeque + " ns | Result: " + result3);
    }

    // Two-pointer approach
    private static boolean twoPointerPalindrome(String input) {
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

    // Stack-based approach
    private static boolean stackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Deque-based approach
    private static boolean dequePalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}