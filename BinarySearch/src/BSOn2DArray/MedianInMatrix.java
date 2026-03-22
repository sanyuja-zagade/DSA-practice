// Q. ind median in a row wise sorted matrix in which total number of rows & columns is odd

package BSOn2DArray;

import java.util.*;

public class MedianInMatrix {
    // BRUTE APPROACH
    // TC -> O(NM * NMlog(NM))
    // SC -> O(N*M)
    public static int BruteSolution(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> ls = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                ls.add(matrix[i][j]);
            }
        }
        Collections.sort(ls);
        return ls.get((n*m)/2);
    }

    // OPTIMAL APPROACH
    // TC -> O(N * log(base 2)M * log(base 2)(max-min))
    // SC -> O(1)
    public static int CountLessEquals(int row[], int ele) {     // Upper Bound
        int low = 0, high = row.length - 1;
        while (low <= high) {
             int mid = (low + high) / 2;
             if (row[mid] > ele) high = mid - 1;
             else low = mid + 1;
        }
        return low;
    }
    public static int OptimalSolution(int matrix[][]) {
        int n = matrix.length, m = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[0][m-1];
        for (int i=0; i<n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m-1]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;

            for (int i=0; i<n; i++) {
                count += CountLessEquals(matrix[i], mid);
            }

            if (count <= (n*m)/2) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public static void main(String args[]) {
        int matrix[][] = {
                {1, 5, 7, 9, 11},
                {2, 3, 4, 5, 10},
                {9, 10, 12, 14, 16}
        };

//        int median = BruteSolution(matrix);
        int median = OptimalSolution(matrix);

        System.out.println(median);
    }
}
