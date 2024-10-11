package output;
import java.util.*;

public class Majority_element {

    public static int majorityElement_BruteForce(int []v) {
        //size of the given array:
        int n = v.length;

        for (int i = 0; i < n; i++) {
            //selected element is v[i]
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of v[i]
                if (v[j] == v[i]) {
                    cnt++;
                }
            }

            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return v[i];
        }

        return -1;
    }


    public static int majorityElement(int []v) {
        //size of the given array:
        int n = v.length;

        //declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();

        //storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);
        }

        //searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }

        return -1;
    }


    /////////////////////////////////////////////////////////////////////////////moore algo = optimal





    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans =  majorityElement_BruteForce(arr);
        System.out.println("The majority element is: " + ans);

    }



    
}






