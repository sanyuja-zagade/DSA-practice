// Problem Statement - remove duplicates in-place from sorted array
//                     i.e., remove duplicates and return the size of array after removing duplicates

// BRUTE FORCE APPROACH => use set and insert all elements of array into set
//                         traverse set and fill first k indices of array with the elements of set
// Time Complexity -> O(NlogN + N)
// Space Complexity -> O(N)

// OPTIMAL SOLUTION => traverse array - 1st ele is always unique
//                                      check for next elements and if the ele is different then place it next to the unique ele
// Time COmplexity -> O(N)
// Space Complexity -> O(1)

public class RemoveDuplicates {
    public static int Duplicates(int arr[]) {
        int i = 0;
        for (int j=1; j<arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }

    public static void main (String args[]) {
        int arr[] = {1, 1, 2, 2, 2, 3, 3};

        int newSize = Duplicates(arr);
        System.out.println(newSize);
    }
}
