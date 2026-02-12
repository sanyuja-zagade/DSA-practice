import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralTraversal {
    // TC -> O(N * M)
    // SC -> O(1) [ans List is part of the output & hence not considered as extra space]
    public static List<Integer> SpiralTraversal(int matrix[][]) {
        List<Integer> ans = new ArrayList<>();

        int left = 0, right = matrix[0].length-1;
        int top = 0, bottom = matrix.length-1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }

    public static void main (String args[]) {
        int matrix[][] = {
                {1,2,3,4,5},
                {16,17,18,19,6},
                {15,24,25,20,7},
                {14,23,22,21,8},
                {13,12,11,10,9}
        };

        List<Integer> result = SpiralTraversal(matrix);

        System.out.println(result);
    }
}
