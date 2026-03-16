import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Recursive Palindrome Checker ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize string before passing to recursion
        String cleanStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanStr.isEmpty()) {
            System.out.println("Result: Empty or non-alphanumeric input.");
        } else if (isPalindromeRecursive(cleanStr, 0, cleanStr.length() - 1)) {
            System.out.println("Result: \"" + input + "\" is a palindrome!");
        } else {
            System.out.println("Result: \"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursive method to check palindrome.
     * @param str The cleaned string.
     * @param left Starting index.
     * @param right Ending index.
     * @return true if palindrome, false otherwise.
     */
    public static boolean isPalindromeRecursive(String str, int left, int right) {
        // BASE CONDITION 1: If pointers cross or meet, we've checked everything.
        if (left >= right) {
            return true;
        }

        // BASE CONDITION 2: If characters at current pointers don't match.
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // RECURSIVE STEP: Move inward and check the remaining substring.
        return isPalindromeRecursive(str, left + 1, right - 1);
    }
}