package output;
import java.util.*;
import java.math.*;

public class Booth { //fooling school

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







