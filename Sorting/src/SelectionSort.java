// SELECTION SORT - selects min ele and push it to front
// -> O(N^2) - [Best, Average, Worst cases]
// Space Complexity -> O(1) - [No extra space used]

import java.util.*;

public class SelectionSort {
    public static void SelectionSortAlgo(int arr[], int n) {
        for (int i=0; i<n-1; i++) {
            int minIndex = i;
            for (int j=i; j<n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // REVERSE SELECTION SORT
    public static void ReverseSelectionSort(int arr[], int n) {
        for (int i=n-1; i>0; i--) {
            int minIndex = i;
            for (int j=i; j>=0; j--) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total count of numbers to be sorted: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter numbers to be sorted: ");
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        SelectionSortAlgo(arr, n);
        ReverseSelectionSort(arr, n);

        // printing sorted array
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
