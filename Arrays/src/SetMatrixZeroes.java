public class SetMatrixZeroes {
    // BRUTE APPROACH
    // TC -> O[(N*M)(N+M)+(N*M)] ~ O(N^3)
    // SC -> O(1)
    public static int[][] SetMatrixZeroBrute(int matrix[][]) {
        // row length
        int n = matrix.length;
        // col length
        int m = matrix[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == 0) {
                    for (int col=0; col<m; col++) {
                        if (matrix[i][col] == 1)
                            matrix[i][col] = -1;
                    }
                    for (int row=0; row<n; row++) {
                        if (matrix[row][j] == 1)
                            matrix[row][j] = -1;
                    }
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    // BETTER APPROACH
    // TC -> O(N * M)
    // SC -> O(N + M)
    public static int[][] SetMatrixZeroBetter(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row[] = new int[n];
        int col[] = new int[m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }

        return matrix;
    }

    // OPTIMAL APPROACH
    // TC -> O(N^2)
    // SC -> O(1)
    public static int[][] SetMatrixZeroOptimal(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0)
                        col0 = 0;
                    else
                        matrix[0][j] = 0;
                }
            }
        }
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                if (matrix[i][j] == 1) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j=0; j<m; j++)
                matrix[0][j] = 0;
        }
        if (col0 == 0) {
            for (int i=0; i<n; i++) {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }

    public static void main(String args[]) {
        int matrix[][] = {{1,1,1,1}, {1,0,1,1}, {0,1,1,1}, {1,0,0,1}};

//        int newMatrix[][] = SetMatrixZeroBrute(matrix);
//        int newMatrix[][] = SetMatrixZeroBetter(matrix);
        int newMatrix[][] = SetMatrixZeroOptimal(matrix);

        for (int row[] : newMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
