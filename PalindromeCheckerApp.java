import java.util.Scanner;
import java.util.Stack;

// --- CLASS 1: THE SERVICE (The Logic) ---
class PalindromeService {
    public boolean isValid(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (clean.isEmpty()) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) {
            stack.push(c);
        }

        for (char c : clean.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// --- CLASS 2: THE APP (The Interface) ---
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeService service = new PalindromeService(); // Create the object

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        if (service.isValid(text)) {
            System.out.println("It's a palindrome!");
        } else {
            System.out.println("Not a palindrome.");
        }
        scanner.close();
    }
}