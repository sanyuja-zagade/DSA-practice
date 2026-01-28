// Union of two sorted array

// BRUTE FORCE APPROACH => use set
//                         1) add elements of arr1 into set, 2) add elements of arr2 into set -> O(N1LogN + N2logN)
//                         copy elements of set to new array having size of set.size -> O(N1 + N2) [Worst case]
// TC -> O(N1LogN + N2logN) + O(N1 + N2) [N is no. of elements in a set - variable]
// SC -> O(N1 + N2) [Worst case] """this is for returning the ans & not for solving"""

// OPTIMAL SOLUTION => take an empty list
//                     traverse both arrays and compare current elements and add smaller one to the list
//                     also don't add duplicate elements
// TC -> O(N1 + N2)
// SC -> O(N1 + N2) [Worst case] """this is for returning the ans & not for solving""" i.e., if space of Union list is considered

import java.util.*;

public class UnionOfArrays {
    public static List<Integer> UnionArray(int arr1[], int arr2[]) {
        int n1 = arr1.length, n2 = arr2.length;
        List<Integer> Union = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                if (Union.isEmpty() || Union.get(Union.size()-1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            }
            else if (arr1[j] < arr1[i]) {
                if (Union.isEmpty() || Union.get(Union.size()-1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
            else {
                if (Union.isEmpty() || Union.get(Union.size()-1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
                j++;
            }
        }
        while (i < n1) {
            if (Union.isEmpty() || Union.get(Union.size()-1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        while (j < n2) {
            if (Union.isEmpty() || Union.get(Union.size()-1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }

        return Union;
    }

    public static void main(String args[]) {
        int arr1[] = {1, 1, 2, 3, 4, 5};
        int arr2[] = {2, 3, 4, 4, 5, 6};

        List<Integer> result = UnionArray(arr1, arr2);

        for (int val : result) System.out.print(val + " ");
    }
}
