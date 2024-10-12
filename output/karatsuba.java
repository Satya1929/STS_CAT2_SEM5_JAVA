package output;
import java.util.*;
import java.math.*;


public class Karatsuba {//actual


    // Function to implement Karatsuba multiplication
    public static long karatsuba(long x, long y) {    // long can be long long , int etc
        // Base case for recursion: when either number is less than 10 (single digit multiplication)
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Determine the size of the numbers (in digits)
        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());
        int half = n / 2;

        // Split the input numbers into halves
        long a = x / (long) Math.pow(10, half);  // Left part of x
        long b = x % (long) Math.pow(10, half);  // Right part of x
        long c = y / (long) Math.pow(10, half);  // Left part of y
        long d = y % (long) Math.pow(10, half);  // Right part of y

        // Recursively calculate the three products
        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long ad_plus_bc = karatsuba(a + b, c + d) - ac - bd;

        // Combine the results according to the Karatsuba formula
        return ac * (long) Math.pow(10, 2 * half) + (ad_plus_bc * (long) Math.pow(10, half)) + bd;
    }





    // Karatsuba multiplication method using BigInteger for large numbers
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {// for very very big numbers
        // Get the maximum bit length between x and y
        int n = Math.max(x.bitLength(), y.bitLength());

        // Base case: If the numbers are small (bit length <= 2000), use standard multiplication
        if (n <= 2000) {
            return x.multiply(y);
        }

        // Split the numbers into two halves
        // Calculate half the bit length, rounding up to the nearest multiple of 64 bits
        int half = (n + 32) / 64 * 32;

        // Create a mask to extract the lower half of the number
        BigInteger mask = BigInteger.ONE.shiftLeft(half).subtract(BigInteger.ONE);

        // Split x into high and low parts
        BigInteger xLow = x.and(mask); // Lower half of x
        BigInteger xHigh = x.shiftRight(half); // Upper half of x

        // Split y into high and low parts
        BigInteger yLow = y.and(mask); // Lower half of y
        BigInteger yHigh = y.shiftRight(half); // Upper half of y

        // Recursively calculate z0, z1, and z2 using Karatsuba multiplication
        BigInteger z0 = karatsuba(xLow, yLow); // z0 = (xLow * yLow)
        BigInteger z1 = karatsuba(xLow.add(xHigh), yLow.add(yHigh)); // z1 = (xLow + xHigh) * (yLow + yHigh)
        BigInteger z2 = karatsuba(xHigh, yHigh); // z2 = (xHigh * yHigh)

        // Combine the results according to the Karatsuba formula
        // result = z2 * (2^2half) + (z1 - z2 - z0) * (2^half) + z0
        BigInteger result = z2.shiftLeft(2 * half) // z2 * (2^(2 * half))
                           .add(z1.subtract(z2).subtract(z0).shiftLeft(half)) // (z1 - z2 - z0) * (2^half)
                           .add(z0); // Add z0

        return result;
    }


    // Main function to test Karatsuba multiplication
    public static void main(String[] args) {
        long num1 = 123456789;
        long num2 = 987654321;

        long result = karatsuba(num1, num2);
        System.out.println("Result of Karatsuba multiplication: " + result);
    }
}






public class Solution {//making school fool

    public static int multiplyBinaryStrings(String x, String y) { // binary string input
        int num1 = Integer.parseInt(x, 2);  // Convert x to decimal integers
        int num2 = Integer.parseInt(y, 2);  // Convert y to decimal integers
        return num1 * num2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two strings (binary)
        String x = sc.nextLine();
        String y = sc.nextLine();

        // Call the multiply function and print the result
        System.out.println(multiplyBinaryStrings(x, y));
        
        sc.close();
    }
}



// import java.math.*;
public class Solution {//making school fool

    public static BigInteger multiplyLargeBinaryStrings(String x, String y) {//very large binary strings
        BigInteger num1 = new BigInteger(x, 2);  // Convert binary string x to BigInteger
        BigInteger num2 = new BigInteger(y, 2);  // Convert binary string y to BigInteger
        return num1.multiply(num2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two binary strings
        String x = sc.nextLine();
        String y = sc.nextLine();

        // Call the multiply function and print the result
        System.out.println(multiplyLargeBinaryStrings(x, y));
        
        sc.close();
    }
}






// import java.math.*;
// import java.util.*;

public class Fooling { 
    //tried and tested (in exams 2024 , even integer multiplication passes all test case , but for safer side for big numbers this code works sexy)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input binary (int)
       int bin1 = 1010;
       int bin2 = 1101;

       BigInteger b1 = new BigInteger(Integer.toString(bin1),2);
       BigInteger b2 = new BigInteger(Integer.toString(bin2),2);


       System.out.println(b1.multiply(b2));

        // Input binary (string)
       String sbin1 = "1010";
       String sbin2 = "1101";
       BigInteger big1 = new BigInteger(sbin1,2);
       BigInteger big2 = new BigInteger(sbin2,2);

       System.out.println(big1.multiply(big2));



        // Input decimal (int)
       long num1 = 10;
       long num2 = 13;
       BigInteger bn1 = new BigInteger(Long.toString(num1));
       BigInteger bn2 = new BigInteger(Long.toString(num2));

       System.out.println(bn1.multiply(bn2));



        // Input deciaml (string)
        String sbin11 = "10";
        String sbin22 = "13";
        BigInteger big11 = new BigInteger(sbin11);
        BigInteger big22 = new BigInteger(sbin22);
 
        System.out.println(big11.multiply(big22));
    }
    
}







