package output;

public class maximum_sum_hour_glass {
    // Function to find maximum hourglass sum
    static int findMaxSum(int[][] mat) {
        int R = mat.length;       // Number of rows
        int C = mat[0].length;    // Number of columns

        // If the matrix has less than 3 rows or 3 columns, no hourglass can exist
        if (R < 3 || C < 3) {
            return -1;
        }

        // Variable to store the maximum sum
        int max_sum = Integer.MIN_VALUE;

        // Traverse the matrix to consider every top-left corner of hourglasses
        for (int i = 0; i <= R - 3; i++) {
            for (int j = 0; j <= C - 3; j++) {
                // Calculate the sum of the current hourglass
                int sum = (mat[i][j] + mat[i][j + 1] + mat[i][j + 2]) // top row
                        + (mat[i + 1][j + 1])                         // middle
                        + (mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2]); // bottom row

                // Update the maximum sum if the current sum is larger
                max_sum = Math.max(max_sum, sum);
            }
        }

        return max_sum; // Return the maximum hourglass sum
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
        };

        int result = findMaxSum(mat);
        System.out.println("Maximum hourglass sum: " + result);
    }
}




public static void main(String[] args) { //variable matrix size when row or column numbers are not specified
    Scanner sc = new Scanner(System.in);
    List<int[]> matrixList = new ArrayList<>();
    
    System.out.println("Enter matrix values row by row (separated by spaces). Press enter on a blank line to finish:");

    while (sc.hasNextLine()) {
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            break;  // Stop input if the user provides a blank line
        }
        String[] values = line.split("\\s+");
        int[] row = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
        matrixList.add(row);
    }

    // Convert list to 2D array
    int[][] matrix = matrixList.toArray(new int[0][0]);

    // Call solve function to find the maximum hourglass sum
    int result = solve(matrix);

    // Output the result
    System.out.println(result);
}




