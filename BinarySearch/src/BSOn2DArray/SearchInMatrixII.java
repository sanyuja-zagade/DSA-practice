// Q. Return index of an element if it is present in a matrix whose rows & cols are sorted individually

package BSOn2DArray;

public class SearchInMatrixII {
    // BRUTE APPROACH
    // TC -> O(N * M)
    // SC -> O(1)
    public static int[] BruteSolution(int matrix[][], int ele) {
        int n = matrix.length, m = matrix[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == ele)
                    return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }
    
    // BETTER APPROACH
    // TC -> O(N * log(base 2)M)
    // SC -> O(1)
    public static int BinarySearchAlgo(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
    public static int[] BetterSolution(int matrix[][], int ele) {
        int n = matrix.length, m = matrix[0].length;
        for (int i=0; i<n; i++) {
            int index = BinarySearchAlgo(matrix[i], ele);
            if (index != -1) return new int[] {i, index};
        }
        return new int[] {-1, -1};
    }

    // OPTIMAL APPROACH
    // TC -> O(N + M)
    // SC -> O(1)
    public static int[] OptimalSolution(int matrix[][], int ele) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m-1;
        while (row < n && col < m) {
            if (matrix[row][col] == ele) return new int[] {row, col};
            else if (matrix[row][col] > ele) col--;
            else row++;
        }
        return new int[] {-1, -1};
    }

    public static void main(String args[]) {
        int matrix[][] = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

//        int index[] = BruteSolution(matrix, 14);
//        int index[] = BetterSolution(matrix, 14);
        int index[] = OptimalSolution(matrix, 14);

        for (int ele : index) System.out.print(ele + " ");
    }
}
