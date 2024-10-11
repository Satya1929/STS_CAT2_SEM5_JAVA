package output;

import java.util.Scanner;

public class Euclid 
{
    public static int euclid_gcd(int a, int b) //Euclidean algorithm for the GCD calculation.
    {
        //assume a = small , b = big .
        if (a == 0) return b;
        else return euclid_gcd(b % a, a); // bcz b is big so b is divided by a , not vice versa
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in) ;
        int a = sc.nextInt() ;
        int b = sc.nextInt() ;
        System.out.println(euclid_gcd(a,b));
    }
    
}
