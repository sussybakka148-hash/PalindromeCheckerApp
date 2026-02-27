import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // Potential logic for Use Case 3: User Input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();
        
        if (checkPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }

    public static boolean checkPalindrome(String str) {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversed);
    }
}