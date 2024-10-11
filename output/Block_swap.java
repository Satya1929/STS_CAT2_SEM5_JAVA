package output;
import java.util.*;

public class Block_swap {//alternative code of bloack swap to rotate array (same efficiency as actual block swap)
    //time = O(2n) = O(n)
    //space = O(1)

    // Function to Reverse the array
    static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void leftRotate(int arr[], int n, int d) {

        if (n == 0) return;

        // Get the effective number of rotations:
        d = d % n;

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void main(String args[]) {
        int n = 7;
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;

        System.out.println("Before rotation:");
        for (int i = 0; i < n; i++)
            System.out.print( arr[i] + " ");
        System.out.println();

        leftRotate(arr, n, d);
        System.out.println("After rotation:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}   











public class Block_swap { ////alternative code of bloack swap to rotate array  (brute force)
    //time = O(n+d) = O(n)
    //space = O(d)
    static void leftRotate(int arr[], int n, int d) {

        if (n == 0) return;
        // Get the effective number of rotations:
        d = d % n;

        // checking if d is a multiple of n:
        if (d == 0) return;

        int[] temp = new int[d]; // temporary array

        //step 1: Copying first d elements
        // in the temporary array:
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        // step 2: Shift last (n-d) elements
        // to the left by d places in the given array:
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        //step 3: Place the elements of the temporary
        // array in the last d places of the given array:
        for (int i = n - d; i < n; i++) {
            arr[i] = temp[i - (n - d)];
        }
    }
    public static void main(String args[]) {
        int n = 7;
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;

        System.out.println("Before rotation:");
        for (int i = 0; i < n; i++)
            System.out.print( arr[i] + " ");
        System.out.println();

        leftRotate(arr, n, d);
        System.out.println("After rotation:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}




public class Block_swap {//actual algo , time = O(n) , space = O(1)
    public static void swap(int[] arr, int a, int b, int k) {
      for (int i = 0; i < k; i++) {
        int temp = arr[a + i];
        arr[a + i] = arr[b + i];
        arr[b + i] = temp;
      }
    }
    public static void BlockSwap(int[] arr, int i, int k, int n) {
      if (k == 0 || k == n)
        return;
      // If first part and second part are of same size
      if (k == n - k) {
        swap(arr, i, n - k + i, k);
        return;
      }
      // If first part of array is of smaller size
      else if (k < n - k) {
        swap(arr, i, n - k + i, k);
        BlockSwap(arr, i, k, n - k); // second part of array is taken now
      }
      // If second part of array is of smaller size
      else {
        swap(arr, i, k, n - k);
        BlockSwap(arr, n - k + i, 2 * k - n, k);
      }
    }
    public static void main(String args[]) {
      int[] arr = {1,2,3,4,5,6,7};
      int n = 7;
      int k = 2;
      BlockSwap(arr, 0, k, n);
      System.out.println("After Rotating the array ");
      for (int i = 0; i < n; i++)
        System.out.print(arr[i] + " ");
    }
  }










