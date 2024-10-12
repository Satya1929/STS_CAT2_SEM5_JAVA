package output;
import java.util.Scanner;

public class Swap_nibble {//decimal (int) input , decimal (int) output give

    // Function to swap two nibbles in a byte
    public static int swapNibbles(int num) {//decimal (int) input , decimal (int) output give
        // return ((num & 0x0F) << 4 | (num & 0xF0) >> 4); //in hexademical notation (zero)(small x letter)(hex value)
        //or
        return ((num & 15) << 4 | (num & 240) >> 4); //in decimal
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); // Step 1: Read an decimal (int) input from the user

        // Step 2: Call the swapNibbles function
        int swapnum = swapNibbles(num);

        // Step 3: Display the results
        System.out.println("Before swapping the nibble: " + num);
        System.out.println("After swapping the nibble: " + swapnum);

        // Close the scanner
        scanner.close();
    }
}




public class Swap_nibble {//decimal (int) input , decimal (int) output give

    public static int swapNibbles(int num) {
        return ((num & 15) << 4 | (num & 240) >> 4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        
        // Step 1: Read a binary (string) input from the user (trick is to take typed binary input as string and not as int)
        String binaryString = scanner.nextLine();
        
        // Step 2: Convert the binary string to a decimal int
        int num = Integer.parseInt(binaryString, 2);

        // Step 3: Call the swapNibbles function to swap the nibbles
        int swappedNum = swapNibbles(num);

        // Step 4: Convert the swapped decimal result back to a binary string
        String swappedBinaryString = Integer.toBinaryString(swappedNum);

        // Step 5: Display the results
        System.out.println("Before swapping the nibble (binary): " + binaryString);
        System.out.println("After swapping the nibble (binary): " + swappedBinaryString);

        // Close the scanner
        scanner.close();
    }
}


class exam {

    //edge cases deal - 
    // if num >255 , invalid input
    // dumbass edge case =  string input length < 8 will be invalid input

    //manually code for test cases as well

}
