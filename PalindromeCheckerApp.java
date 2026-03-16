import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (checkPalindromeUsingQueueStack(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }

    public static boolean checkPalindromeUsingQueueStack(String str) {

        // Remove spaces and convert to lowercase
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Push into stack and enqueue into queue
        for (char c : cleanStr.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        // Compare dequeue vs pop
        while (!stack.isEmpty()) {

            char fromStack = stack.pop();
            char fromQueue = queue.remove();

            if (fromStack != fromQueue) {
                return false;
            }
        }

        return true;
    }
}