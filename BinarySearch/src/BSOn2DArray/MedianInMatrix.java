// Q. ind median in a row wise sorted matrix in which total number of rows & columns is odd

package BSOn2DArray;

import java.util.*;

public class MedianInMatrix {
    // BRUTE APPROACH
    // TC -> O(N*M * log(NM))
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

    public static void main(String args[]) {
        int matrix[][] = {
                {1, 5, 7, 9, 11},
                {2, 3, 4, 5, 10},
                {9, 10, 12, 14, 16}
        };

        int median = BruteSolution(matrix);

        System.out.println(median);
    }
}
