package output;
import java.util.*;

public class Majority_element {

    public static int majorityElement_BruteForce(int []v) {
        //size of the given array:
        int n = v.length;

        for (int i = 0; i < n; i++) {
            //selected element is v[i]
            int count = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of v[i]
                if (v[j] == v[i]) {
                    count++;
                }
            }

            // check if frquency is greater than n/2:
            if (count > (n / 2))
                return v[i];
        }

        return -1;
    }


    public static int majorityElement_better(int []v) {
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

    public static int majorityElement_moore_version1(int []v) {
        //size of the given array:
        int n = v.length; //not lenght()
        int count = 0; // count = balacing count 
        int candidatee = 0; // Element

        //Step 1 - applying the algorithm:
        for (int i = 0; i < n; i++) 
        {
            if (count == 0) 
            {
                count = 1;
                candidatee = v[i];
            } 
            else if (candidatee == v[i]) count++;
            else count--;
        }

        //Step2 - verify if the stored element is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < n; i++) 
        {
            if (v[i] == candidatee) cnt1++;
        }
        if (cnt1 > (n / 2)) return candidatee;

        return -1;
    }


    public int majorityElement_moore_version2(int[] v) // best with for each loop
    {
        //algo
        int candi = 0 ;
        int count = 0 ;
        
        for(int ele : v)
        {
            if (count == 0) candi = ele ;
            if (ele == candi) count++ ;
            else count-- ;
        }
        
        //verify
        int anscount = 0 ;
        for(int ele : v) if(ele==candi) anscount++ ;
        if (anscount > (v.length/2)) return candi ;
        else return -1 ;       
        
    }

    //or

    public int majorityElement_moore_version2(int[] nums) { //easier with for each loop + skip verification
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        //skip the verification 
        return candidate;
    }


    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans =  majorityElement_BruteForce(arr);
        System.out.println("The majority element is: " + ans);

    }



    
}






