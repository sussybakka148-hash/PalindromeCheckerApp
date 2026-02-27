public class PalindromeCheckerApp {
    public static void main(String[] args) {
        // Step 10: Initial logic for Palindrome checking
        String word = "madam";
        String reversedWord = new StringBuilder(word).reverse().toString();
        
        if (word.equals(reversedWord)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}