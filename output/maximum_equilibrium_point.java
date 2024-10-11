package output;

public class maximum_equilibrium_point {

    static int findMaxSum_brute(int[] arr, int n) {
        int res = Integer.MIN_VALUE;

        // Outer loop to iterate through each element of the array
        for (int i = 0; i < n; i++) {
            // Calculate prefix sum (sum of elements from index 0 to i)
            int prefix_sum = arr[i];
            for (int j = 0; j < i; j++)
                prefix_sum += arr[j];

            // Calculate suffix sum (sum of elements from index i to n-1)
            int suffix_sum = arr[i];
            for (int j = n - 1; j > i; j--)
                suffix_sum += arr[j];

            // Check if the prefix sum is equal to the suffix sum
            if (prefix_sum == suffix_sum) {
                // Update the result with the maximum equilibrium sum
                res = Math.max(res, prefix_sum);
            }
        }
        return res; // Return the maximum equilibrium sum
    }




    static int findMaxSum_optimal(int []arr, int n) {//O(n)
        int []preSum = new int[n];  // Array to store prefix sums
        int []suffSum = new int[n]; // Array to store suffix sums
        int ans = Integer.MIN_VALUE; // To store the maximum equilibrium sum, initialized to the smallest value

        // Step 1: Calculate prefix sums
        preSum[0] = arr[0];  // The first element of prefix sum is just the first element of the array
        for (int i = 1; i < n; i++)
            preSum[i] = preSum[i - 1] + arr[i];  // Each prefix sum is the sum of the current element and the previous prefix sum

        // Step 2: Calculate suffix sums
        suffSum[n - 1] = arr[n - 1]; // The last element of the suffix sum is just the last element of the array
        for(int i = n - 2; i >= 0; i--)
            suffSum[i] = suffSum[i + 1] + arr[i];  // Each suffix sum is the sum of the current element and the next suffix sum

        // Step 3: Check if the overall sum (left + right) is equal at some index
        if (preSum[n - 1] == suffSum[n - 1]) {
            ans = Math.max(ans, preSum[n - 1]); // Special case: If the total sum is equal for the entire array
        }

        // Step 4: Check for equilibrium points
        for(int i = n - 2; i >= 0; i--) {
            if (suffSum[i] == preSum[i]) {  // If at index 'i', the prefix sum equals the suffix sum
                ans = Math.max(ans, preSum[i]); // Update the maximum equilibrium sum
            }
        }

        return ans;  // Return the maximum equilibrium sum
    }

    static public void main (String[] args) {
        int []arr = { -2, 5, 3, 3, 2, 6, -4, 2 };  // Example input array
        int n = arr.length;  // Length of the array
        System.out.println(findMaxSum(arr, n));  // Output the result of the findMaxSum function
    }
    
}





static int findMaxSum(int []arr, int n)
{
  int res = Integer.MIN_VALUE;
  for (int i = 0; i < n; i++)
{
int prefix_sum = arr[i];		
for (int j = 0; j < i; j++)
prefix_sum += arr[j];
     int suffix_sum = arr[i];
     for (int j = n - 1; j > i; j--)
suffix_sum += arr[j];
if (prefix_sum == suffix_sum)
     res = Math.max(res, prefix_sum);
    }
    return res;
}
