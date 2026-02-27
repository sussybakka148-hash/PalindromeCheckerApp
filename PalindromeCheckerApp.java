import javax.swing.JOptionPane;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        boolean continueChecking = true;

        while (continueChecking) {
            // Step 1: Get user input via a Dialog Box
            String input = JOptionPane.showInputDialog(null, 
                "Enter a word or phrase to check:", 
                "Palindrome Checker v3.0", 
                JOptionPane.QUESTION_MESSAGE);

            // Handle Cancel button or empty input
            if (input == null) break; 
            
            if (input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid word!");
                continue;
            }

            // Step 2: Logic to check palindrome
            boolean isPalindrome = checkPalindrome(input);

            // Step 3: Display Result
            String result = isPalindrome 
                ? "YES! '" + input + "' is a palindrome." 
                : "NO. '" + input + "' is NOT a palindrome.";
            
            JOptionPane.showMessageDialog(null, result);

            // Step 4: Ask to go again
            int choice = JOptionPane.showConfirmDialog(null, 
                "Do you want to check another word?", 
                "Continue?", 
                JOptionPane.YES_NO_OPTION);
            
            if (choice != JOptionPane.YES_OPTION) {
                continueChecking = false;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Thank you for using the App!");
    }

    // Advanced Palindrome Logic: Ignores case and non-alphanumeric characters
    public static boolean checkPalindrome(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversed);
    }
}