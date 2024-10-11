package output;

public class Longest_sequence1s_after_flip_k_zeros { //java solution

    public int longestOnes(int[] arr, int k) {//brute force
        int maxlen = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            int zeros = 0;
            for (int j = i; j <= arr.length - 1; j++) {  
                if (arr[j] == 0) zeros++;
                if (zeros <= k) 
                {
                    int len = j - i + 1;
                    maxlen = Math.max(maxlen, len);
                } 
                else 
                {
                    break;  // Zeros exceeded, try next subarray
                }
            }
        }
        return maxlen;
    }
    


    public int longestOnes(int[] arr, int k) {//sliding window O(2n) approach striver
        int maxlen = 0, l = 0, r = 0, zeros = 0;

        while (r <= arr.length - 1) {  
            if (arr[r] == 0) zeros++;
            
            while (zeros > k) {
                if (arr[l] == 0) zeros--;
                l++;  // Increment the left pointer (Inner while loop)
            }
            
            if (zeros <= k) {
                int len = r - l + 1;
                maxlen = Math.max(len, maxlen);  
            }

            r++;  // Always Increment the right pointer (outer while loop)
        }
        
        return maxlen;
    }


}

