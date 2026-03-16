import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string (Linked List Check): ");
        String input = scanner.nextLine();

        if (isPalindromeLinkedList(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        scanner.close();
    }

    public static boolean isPalindromeLinkedList(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (cleanStr.isEmpty()) return true;

        // Step 1: Convert String to Singly Linked List
        Node head = new Node(cleanStr.charAt(0));
        Node current = head;
        for (int i = 1; i < cleanStr.length(); i++) {
            current.next = new Node(cleanStr.charAt(i));
            current = current.next;
        }

        // Step 2: Find the middle using Fast and Slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse the second half of the list
        Node secondHalfHead = reverseList(slow);
        Node firstHalfHead = head;

        // Step 4: Compare the two halves
        Node tempSecond = secondHalfHead;
        while (tempSecond != null) {
            if (firstHalfHead.data != tempSecond.data) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    // Helper method for In-Place Reversal
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}