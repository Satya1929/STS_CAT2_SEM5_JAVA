package output;

public class Longest_sequence1s_after_flip_k_zeros { //java solution

    public int longestOnes_brute(int[] arr, int k) {//brute force
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
    


    public int longestOnes_optimal(int[] arr, int k) {//sliding window O(2n) approach striver
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

    //only toughness was taking input in exam , which was like this
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read binary string input (e.g., "1,0,1,0,0,1")
        System.out.print("Enter binary string (comma separated): ");
        String binaryInput = sc.nextLine();

        // Step 2: Convert the binary string into an integer array
        String[] binaryStringArr = binaryInput.split(","); // Split the input by commas
        int[] arr = new int[binaryStringArr.length]; // Create an integer array

        for (int i = 0; i < binaryStringArr.length; i++) {
            arr[i] = Integer.parseInt(binaryStringArr[i].trim()); // Convert each string to int
        }

        // Step 3: Read the value of 'k' (maximum number of zeros to flip)
        System.out.print("Enter the value of k (max number of zeros to flip): ");
        int k = sc.nextInt();

        // Step 4: Call the longestOnes_optimal function and print the result
        Solution solution = new Solution();
        int result = solution.longestOnes_optimal(arr, k);
        System.out.println("The longest sequence of 1's after flipping " + k + " zeros is: " + result);
        
        sc.close();
    }


}

