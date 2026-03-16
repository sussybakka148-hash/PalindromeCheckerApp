import java.util.*;

// --- UC12: THE STRATEGY INTERFACE ---
// This defines the "contract" for all palindrome algorithms.
interface PalindromeStrategy {
    boolean check(String input);
}

// --- UC7: DEQUE STRATEGY ---
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        // UC10: Normalization logic applied here
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (clean.isEmpty()) return false;

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// --- UC9: RECURSIVE STRATEGY ---
class RecursiveStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (clean.isEmpty()) return false;
        return isPalindrome(clean, 0, clean.length() - 1);
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindrome(s, left + 1, right - 1);
    }
}

// --- UC11: STACK STRATEGY ---
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (clean.isEmpty()) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        
        for (char c : clean.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// --- UC11: THE SERVICE (CONTEXT) ---
class PalindromeService {
    private PalindromeStrategy strategy;

    // Set the algorithm at runtime (Dependency Injection)
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String text) {
        if (strategy == null) {
            System.out.println("Error: No algorithm selected.");
            return false;
        }
        return strategy.check(text);
    }
}

// --- MAIN APPLICATION ---
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeService service = new PalindromeService();

        System.out.println("======================================");
        System.out.println("   ADVANCED PALINDROME CHECKER APP    ");
        System.out.println("======================================");
        
        System.out.println("Choose an Algorithm:");
        System.out.println("1. Deque (UC7 - Optimized)");
        System.out.println("2. Recursion (UC9 - Elegant)");
        System.out.println("3. Stack (UC11 - Reversal)");
        System.out.print("Selection (1-3): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        // Dynamic Strategy Selection (Polymorphism)
        switch (choice) {
            case 1 -> service.setStrategy(new DequeStrategy());
            case 2 -> service.setStrategy(new RecursiveStrategy());
            case 3 -> service.setStrategy(new StackStrategy());
            default -> {
                System.out.println("Invalid choice. Defaulting to Deque.");
                service.setStrategy(new DequeStrategy());
            }
        }

        System.out.print("\nEnter the string to check: ");
        String input = scanner.nextLine();

        if (service.execute(input)) {
            System.out.println("\nSUCCESS: \"" + input + "\" is a palindrome!");
        } else {
            System.out.println("\nRESULT: \"" + input + "\" is NOT a palindrome.");
        }

        System.out.println("======================================");
        scanner.close();
    }
}