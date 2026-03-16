import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC10: Case-Insensitive & Space-Ignored Checker ---");
        System.out.print("Enter your phrase: ");
        String input = scanner.nextLine();

        // STEP 1: Normalization (The core of UC10)
        String processed = normalizeString(input);

        // STEP 2: Validation (Applying logic from previous UCs)
        if (processed.isEmpty()) {
            System.out.println("Invalid input: No alphanumeric characters found.");
        } else if (isPalindrome(processed)) {
            System.out.println("Result: Success! It is a palindrome.");
            System.out.println("Processed form: " + processed);
        } else {
            System.out.println("Result: Not a palindrome.");
        }

        scanner.close();
    }

    /**
     * UC10 Key Concept: String Preprocessing
     * Uses Regex to strip non-essential characters.
     */
    public static String normalizeString(String str) {
        if (str == null) return "";
        
        // 1. Convert to lowercase to ignore case
        // 2. Use regex [^a-zA-Z0-9] to remove all non-alphanumeric characters
        return str.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    /**
     * Simple Two-Pointer logic to validate the normalized string.
     */
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}