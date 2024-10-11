package output;

public class lexicographically_first_palindrome {

    public static void main(String[] args) {
        String word = "malalam";
        int[] freq = new int[26];
        
        // Fill the frequency array with the count of each character in the input string
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;  // Subtracting 'a' gives the index (0-25) for the character
        }

        // Variable to count how many characters have an odd frequency
        int oddcount = 0;

        // Loop to count how many characters have odd frequencies
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 != 0) { // Check if the frequency is odd
                oddcount++;
            }
            // If more than 1 character has an odd frequency, a palindrome is not possible
            if (oddcount > 1) {
                System.out.println("no palindrome");
                return; // Exit the program as no palindrome can be formed
            }
        }

        // String to store the character that has an odd frequency (if any)
        String oddchar = "";

        // String to build the first half (front) of the palindrome
        String front = "";

        // Loop through the frequency array again to build the palindrome
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {  // If the character appears in the input string
                // If the character has an odd frequency, store it as the middle character
                if (freq[i] % 2 != 0) {
                    oddchar = "" + ((char) (i + 'a'));  // Convert the index back to a character
                }
                // Add half the occurrences of the character to the front half of the palindrome
                for (int j = 0; j < freq[i] / 2; j++) {
                    front += ((char) (i + 'a'));  // Append the character to the front
                }
            }
        }

        // Reverse the front string to get the rear half of the palindrome
        StringBuilder rear = new StringBuilder(front);
        rear = rear.reverse();

        // Print the final palindrome: front + oddchar (middle character) + rear
        System.out.println(front + oddchar + rear);
    }
}



