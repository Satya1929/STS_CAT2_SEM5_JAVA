package output;
import java.util.*;


import java.math.BigInteger;


public class Karatsuba {


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











