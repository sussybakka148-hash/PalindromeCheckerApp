import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (checkPalindromeUsingStack(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }

    public static boolean checkPalindromeUsingStack(String str) {

        // Remove spaces and convert to lowercase
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char c : cleanStr.toCharArray()) {
            stack.push(c);
        }

        // Compare with popped characters
        for (int i = 0; i < cleanStr.length(); i++) {
            if (cleanStr.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}