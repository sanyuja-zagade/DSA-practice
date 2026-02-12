public class RotateMatrix90deg {
    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(N^2)
    public static int[][] RotateMatrixBrute(int matrix[][]) {
        int n = matrix.length;
        int temp[][] = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                temp[j][n-1-i] = matrix[i][j];
            }
        }

        return temp;
    }

    // OPTIMAL APPROACH
    // TC -> O(N^2)
    // SC -> O(1)
    public static int[][] RotateMatrixOptimal(int matrix[][]) {
        int n = matrix.length;
        // Transpose of matrix
        for (int i=0; i<n-1; i++) {         // O(N/2 * N/2)
            for (int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i=0; i<n; i++) {           // O(N) * O(N/2)
            int left = 0, right = n-1;
            while (left < right) {          // O(N/2)
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++; right--;
            }
        }

        return matrix;
    }

    public static void main(String args[]) {
        int matrix[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

//        int newMatrix[][] = RotateMatrixBrute(matrix);
        int newMatrix[][] = RotateMatrixOptimal(matrix);

        for (int row[] : newMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
