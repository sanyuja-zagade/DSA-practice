package BSOn2DArray;

public class FindPeakElement {
    // TC -> O(N * log(base 2)M)
    // SC -> O(1)
    public static int MaxEle(int matrix[][], int col) {
        int n = matrix.length;
        int maxEle = Integer.MIN_VALUE;
        int index = -1;
        for (int i=0; i<n; i++) {
            if (matrix[i][col] > maxEle) {
                maxEle = matrix[i][col];
                index = i;
            }
        }
        return index;
    }
    public static int Solution(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = m-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = MaxEle(matrix, mid);
            int left = mid-1 >= 0 ? matrix[row][mid-1] : Integer.MIN_VALUE;
            int right = mid+1 < m ? matrix[row][mid+1] : Integer.MIN_VALUE;
            if (matrix[row][mid] > left && matrix[row][mid] > right) return matrix[row][mid];
            else if (matrix[row][mid] > left) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        int matrix[][] = {
                {4, 2, 5, 1, 4, 5},
                {2, 9, 3, 2, 3, 2},
                {1, 7, 6, 0, 1, 3},
                {3, 6, 2, 3, 7, 2}
        };

        int peakEle = Solution(matrix);

        System.out.println(peakEle);
    }
}
