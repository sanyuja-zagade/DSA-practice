// Q. Return smallest index which contains maximum number of 1s in nXm matrix containing 0s & 1s, where is row is sorted

package BSOn2DArray;

public class RowWithMaxOnes {
    // BRUTE APPROACH
    // TC -> O(N*M)
    // SC -> O(1)
    public static int BruteSolution(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        int index = -1;
        int maxCount = 0;
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<m; j++) {
                count += matrix[i][j];
            }
            if (count > maxCount) {
                index = i;
                maxCount = count;
            }
        }
        return index;
    }

    // OPTIMAL APPROACH
    // TC -> O(N * log(base 2)M)
    // SC -> O(1)
    public static int LowerBound(int arr[], int x) {      // can also use UpperBound(arr, x: 0)
        int ans = arr.length;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    public static int OptimalSolution(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        int index = -1;
        int maxCount = 0;
        for (int i=0; i<n; i++) {
            int countOne = m -  LowerBound(matrix[i], 1);
            if (countOne > maxCount) {
                index = i;
                maxCount = countOne;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        int matrix[][] = {
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1}
        };

//        int index = BruteSolution(matrix);
        int index = OptimalSolution(matrix);

        System.out.println(index);
    }
}
