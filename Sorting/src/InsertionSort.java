// INSERTION SORT - takes an ele & place it at its correct order
// -> O(N^2) - [Average & Worst cases]
// -> O(N) - [Best case]

import java.util.*;
public class InsertionSort {
    public static void InsertionSortAlgo(int arr[], int n) {
        for (int i=0; i<n; i++) {
            int j=i;
            while (j>0 && arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--;
            }
        }
    }

    // REVERSE INSERTION SORT
    public static void ReverseInsertionSort(int arr[], int n) {
        for (int i=0; i<n; i++) {
            int j=i;
            while (j>0 && arr[j] > arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--;
            }
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

        InsertionSortAlgo(arr, n);
        ReverseInsertionSort(arr, n);

        // printing arrays
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
