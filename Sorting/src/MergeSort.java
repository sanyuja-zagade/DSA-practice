// MERGE SORT - divide & merge
// -> O(Nlog(base 2)(N))
// Space Complexity -> O(N) - [Worst case]

import java.util.*;
public class MergeSort {
    // Merging Algorithm
    public static void Merge(int arr[], int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();

        int left = low, right = mid+1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        // Add remaining elements of left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        // Add remaining elements of right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        // Copying sorted array back to original arr[]
        for (int i=low; i<=high; i++) {
            arr[i] = temp.get(i-low);
        }
    }
    public static void MergeSortAlgo(int arr[], int low, int high) {
        if (low == high) return;

        int mid = (low + high) / 2;

        // Left half
        MergeSortAlgo(arr, low, mid);
        // Right half
        MergeSortAlgo(arr, mid+1, high);
        // Sorting
        Merge(arr, low, mid, high);
    }

    // Print array elements
    public static void PrintArray(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = {4, 9, 5, 1, 2, 1, 6};

        MergeSortAlgo(arr, 0, arr.length-1);

        PrintArray(arr);
    }
}
