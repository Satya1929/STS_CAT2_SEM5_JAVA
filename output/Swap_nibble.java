package output;
import java.util.Scanner;

public class Swap_nibble {

    // Function to swap two nibbles in a byte
    public static int swapNibbles(int num) {
        // return ((num & 0x0F) << 4 | (num & 0xF0) >> 4);
        //or
        return ((num & 15) << 4 | (num & 240) >> 4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); // Step 1: Read an integer input from the user

        // Step 2: Call the swapNibbles function
        int swapnum = swapNibbles(num);

        // Step 3: Display the results
        System.out.println("Before swapping the nibble: " + num);
        System.out.println("After swapping the nibble: " + swapnum);

        // Close the scanner
        scanner.close();
    }
}
