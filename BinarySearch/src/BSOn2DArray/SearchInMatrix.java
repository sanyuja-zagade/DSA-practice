// Q. Check if an element is present in a sorted matrix

package BSOn2DArray;

public class SearchInMatrix {
    // BRUTE APPROACH
    // TC -> O(N * M)
    // SC -> O(1)
    public static boolean BruteSolution(int matrix[][], int ele) {
        int n = matrix.length, m = matrix[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == ele)
                    return true;
            }
        }
        return false;
    }

    // BETTER SOLUTION
    // TC -> O(N + log(base 2)N)
    // SC -> O(1)
    public static boolean BinarySearchAlgo(int arr[], int ele) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == ele) return true;
            else if (arr[mid] > ele) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
    public static boolean BetterSolution(int matrix[][], int ele) {
        int n = matrix.length, m = matrix[0].length;
        for (int i=0; i<n; i++) {
            if (matrix[i][0] <= ele && matrix[i][m-1] >= ele)
                return BinarySearchAlgo(matrix[i], ele);
        }
        return false;
    }

    // OPTIMAL APPROACH
    // TC -> O(log(base 2) N*M)
    // SC -> O(1)
    public static boolean OptimalSolution(int matrix[][], int ele) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = (n * m) - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            if (matrix[row][col] == ele) return true;
            else if (matrix[row][col] > ele) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }


    public static void main(String args[]) {
        int matrix[][] = {
                {2, 4, 7, 9},
                {12, 13, 16, 18},
                {20, 21, 23, 29}
        };

//        boolean eleExist = BruteSolution(matrix, 23);
//        boolean eleExist = BetterSolution(matrix, 23);
        boolean eleExist = OptimalSolution(matrix, 3);

        System.out.println(eleExist);
    }
}
