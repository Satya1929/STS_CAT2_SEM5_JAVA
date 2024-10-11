package output;

public class Euclid 
{
    public static int euclid_gcd(int a, int b) //Euclidean algorithm for the GCD calculation.
    {
        if (a == 0)
            return b;
        else
        {
            return euclid_gcd(b % a, a);
        }   
    }
    
}

