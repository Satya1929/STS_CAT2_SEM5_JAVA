package output;
import java.util.*;

public class extended_euclid {
    vector<int> gcd(int a, int b) {
        // Use the extended Euclidean function
        triplet result = extendedEuclid(a, b);
        
        // Return gcd, x, and y in a vector
        return {result.gcd, result.x, result.y};
    }
    
    struct triplet {
        int gcd;
        int x;
        int y;
    };
    
    triplet extendedEuclid(int a, int b) {
        if (b == 0) {
            triplet ans;
            ans.x = 1;
            ans.gcd = a;
            ans.y = 0;
            return ans;
        }

        triplet smallAns = extendedEuclid(b, a % b);
        triplet ans;
        ans.gcd = smallAns.gcd;
        ans.x = smallAns.y;
        ans.y = smallAns.x - (a / b) * smallAns.y;

        return ans;
    }


    public static void main(String args[]) {

        

    }
    
    
}

