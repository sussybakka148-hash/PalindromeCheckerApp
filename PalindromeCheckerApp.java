import java.util.*;

/**
 * PalindromeStrategy: The interface for our Strategy Pattern (UC12).
 */
interface PalindromeStrategy {
    boolean check(String input);
    String getName();
}

/**
 * UC7: Optimized Deque Strategy. 
 * High performance, O(n) time, O(n) space.
 */
class DequeStrategy implements PalindromeStrategy {
    public String getName() { return "Deque (Double-Ended)"; }
    public boolean check(String input) {
        String clean = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (clean.isEmpty()) return false;
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : clean.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

/**
 * UC9: Recursive Strategy.
 * Elegant, mathematical approach using the Call Stack.
 */
class RecursiveStrategy implements PalindromeStrategy {
    public String getName() { return "Recursive (Stack-Based)"; }
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

/**
 * UC11: Stack Strategy.
 * Demonstrates LIFO (Last-In-First-Out) for string reversal.
 */
class StackStrategy implements PalindromeStrategy {
    public String getName() { return "Stack (Reversal)"; }
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

/**
 * PalindromeService: The Orchestrator.
 * Handles benchmarking and algorithm execution (UC11 & UC13).
 */
class PalindromeService {
    private final List<PalindromeStrategy> strategies = new ArrayList<>();

    public void registerStrategy(PalindromeStrategy s) { strategies.add(s); }

    public void runBenchmark(String text) {
        System.out.println("\n" + "=".repeat(60));
        System.out.printf("%-25s | %-12s | %-15s\n", "ALGORITHM", "RESULT", "TIME (ns)");
        System.out.println("-".repeat(60));

        for (PalindromeStrategy strategy : strategies) {
            long startTime = System.nanoTime();
            boolean isPalindrome = strategy.check(text);
            long endTime = System.nanoTime();
            
            long duration = endTime - startTime;
            String resultText = isPalindrome ? "✓ PALINDROME" : "✗ NO";
            
            System.out.printf("%-25s | %-12s | %-15d\n", 
                strategy.getName(), resultText, duration);
        }
        System.out.println("=".repeat(60));
    }
}

/**
 * Main App Class
 */
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeService service = new PalindromeService();

        // Registering all algorithmic approaches
        service.registerStrategy(new DequeStrategy());
        service.registerStrategy(new RecursiveStrategy());
        service.registerStrategy(new StackStrategy());

        System.out.println("💎 PALINDROME ENGINE v2.0 - PERFORMANCE EDITION 💎");
        System.out.println("Objective: UC7 to UC13 Validation & Benchmarking");
        
        System.out.print("\n👉 Enter text to analyze: ");
        String input = scanner.nextLine();

        if (input.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty.");
        } else {
            service.runBenchmark(input);
        }

        System.out.println("\nProcess complete. All algorithms executed successfully.");
        scanner.close();
    }
}