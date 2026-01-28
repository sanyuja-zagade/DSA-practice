// BRUTE FORCE APPROACH => take a visited list/vector of n2 size (smaller array size)
// TC -> O(N1 * N2)
// SC -> O(N2)

// OPTIMAL SOLUTION
// TC -> O(N1 + N2) [Worst case] [if none of the elements are same and we are just moving pointers forward one after another]
// SC -> O(1)

import java.util.*;

public class IntersectionOfArray {
    public static List<Integer> IntersectionArrayBrute(int arr1[], int arr2[]) {
        int n1 = arr1.length, n2 = arr2.length;
        int visited[] = new int[n2];
        List<Integer> Intersection = new ArrayList<>();

        for (int i=0; i<n1; i++) {
            for (int j=0; j<n2; j++) {
                if (arr1[i] == arr2[j] && visited[j] == 0) {
                    Intersection.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }
                if (arr1[i] < arr2[j]) break;
            }
        }

        return Intersection;
    }
    public static List<Integer> IntersectionArrayOptimal(int arr1[], int arr2[]) {
        int n1 = arr1.length, n2 = arr2.length;
        List<Integer> Intersection = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) i++;
            else if (arr2[j] < arr1[i]) j++;
            else {
                Intersection.add(arr1[i]);
                i++; j++;
            }
        }

        return Intersection;
    }

    public static void main(String args[]) {
        int arr1[] = {1, 2, 2, 3, 3, 4, 5, 6};
        int arr2[] = {2, 3, 3, 5, 6, 6, 7};

        List<Integer> result1 = IntersectionArrayBrute(arr1, arr2);
        List<Integer> result2 = IntersectionArrayOptimal(arr1, arr2);

        for (int val : result1) System.out.print(val + " ");
    }
}
