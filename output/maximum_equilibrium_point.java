package output;

public class maximum_equilibrium_point {

    static int findMaxSum_brute(int[] arr, int n) {
        int res = Integer.MIN_VALUE;

        // Outer loop to iterate through each element of the array
        for (int i = 0; i < n; i++) {
            // Calculate leftsum total_sum (total_sum of elements from index 0 to i)
            int prefix_sum = arr[i];
            for (int j = 0; j < i; j++)
                prefix_sum += arr[j];

            // Calculate suffix total_sum (total_sum of elements from index i to n-1)
            int suffix_sum = arr[i];
            for (int j = n - 1; j > i; j--)
                suffix_sum += arr[j];

            // Check if the leftsum total_sum is equal to the suffix total_sum
            if (prefix_sum == suffix_sum) {
                // Update the result with the maximum equilibrium total_sum
                res = Math.max(res, prefix_sum);
            }
        }
        return res; // Return the maximum equilibrium total_sum
    }




    static int findMaxSum_better(int []arr, int n) {//O(n)
        int []preSum = new int[n];  // Array to store leftsum sums (element including)
        int []suffSum = new int[n]; // Array to store suffix sums  (element including)
        int ans = Integer.MIN_VALUE; // To store the maximum equilibrium total_sum, initialized to the smallest value

        // Step 1: Calculate leftsum sums
        preSum[0] = arr[0];  // The first element of leftsum is just the first element of the array
        for (int i = 1; i <= n-1; i++)
            preSum[i] = preSum[i - 1] + arr[i];  // Each leftsum  is the total_sum of the current element and the previous leftsum total_sum

        // Step 2: Calculate suffix sums
        suffSum[n - 1] = arr[n - 1]; // The last element of the suffix total_sum is just the last element of the array
        for(int i = n - 2; i >= 0; i--)
            suffSum[i] = suffSum[i + 1] + arr[i];  // Each suffix total_sum is the total_sum of the current element and the next suffix total_sum

        // Step 4: Check for equilibrium points
        for(int i = n - 1; i >= 0; i--) {
            if (suffSum[i] == preSum[i]) {  // If at index 'i', the leftsum total_sum equals the suffix total_sum
                ans = Math.max(ans, preSum[i]); // Update the maximum equilibrium total_sum
            }
        }

        return ans;  // Return the maximum equilibrium total_sum
    }

    static public void main (String[] args) {
        int []arr = { -2, 5, 3, 3, 2, 6, -4, 2 };  // Example input array
        int n = arr.length;  // Length of the array
        System.out.println(findMaxSum(arr, n));  // Output the result of the findMaxSum function
    }
    
}



    // Function to find the maximum equilibrium total_sum
    public static int findMaxEquilibriumSum_optimal(int[] arr) {
        int n = arr.length;
        int total_sum = 0;

        // Calculate total_sum of the array
        for (int i = 0; i < n; i++) {
            total_sum += arr[i];
        }

        int leftsum = 0; // 0 to i-1 element + i element
        int max_equi_sum = Integer.MIN_VALUE;
        // Iterate to find the maximum equilibrium total_sum
        for (int i = 0; i < n; i++) {
            leftsum += arr[i]; //i element + i+1 to last element
            if ( leftsum == total_sum) //totalsum is now used for rightsum
            { 
                max_equi_sum = Math.max(max_equi_sum, leftsum);
            }
            total_sum -= arr[i]; // here totalsum is now being used for rightsum
        }

        return max_equi_sum; // Return the maximum equilibrium total_sum
    }