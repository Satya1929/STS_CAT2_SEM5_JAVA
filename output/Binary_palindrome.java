package output ;
import java.util.*;

public class Binary_palindrome {
    static boolean checkPalindromeInBinary1(int n) //string reversal approach
    {
        // Convert the number to binary string
        String s1 = Integer.toBinaryString(n);
        
        // Reverse the string and check if it's the same as the original
        String s2 = new StringBuilder(s1).reverse().toString();  
        return s1.equals(s2);


        /*String s2 = new StringBuilder(s1).reverse().toString();:
        new StringBuilder(s1): Creates a new StringBuilder object initialized with the value of s1. StringBuilder is used here because it provides a convenient way to reverse strings.
        .reverse(): Reverses the order of characters in the StringBuilder. For example, if s1 is "1001", reversing it will produce "1001".
        .toString(): Converts the reversed StringBuilder back into a regular String to compare with s1 in next line . This resulting string is stored in s2. So, if s1 is "1001", then s2 will also be "1001" after reversal. */
    }

    static boolean checkPalindromeInBinary2(int n)  //two pointer approach
    {
        String s = Integer.toBinaryString(n);
    
        // Two-pointer approach for palindrome check
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }



    public static void main(String[] args) 
    {
        int x = 5;
        System.out.println(checkPalindromeInBinary2(x));
        x = 10;
        System.out.println(checkPalindromeInBinary2(x));
    }

}


