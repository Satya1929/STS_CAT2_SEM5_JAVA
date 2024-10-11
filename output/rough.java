package output;

import java.util.*;

public class rough {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //parseInt takes string to int
        //if no radiz , then same value goes
        //if radix = 2 , then binary to decimal convert also

        // Input binary (string)
        String binaryString = sc.nextLine();
        int ans = Integer.parseInt(binaryString, 2);
        System.out.println(ans);


        // Input decimal (string)
        String DecimalString = sc.nextLine();
        int decimalValue = Integer.parseInt(DecimalString);
        String binarystring = Integer.toBinaryString(decimalValue);
        int ans2 = Integer.parseInt(binarystring);
        System.out.println(ans2);

        //integer number to string number
        int number = 42;
        String str = Integer.toString(number);
        System.out.println(str); // Output: "42"

    }

}
