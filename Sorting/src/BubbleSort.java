// BUBBLE SORT - push the max ele to the last by adjacent swaps
// -> O(N^2) - [Average & Worst cases]
// -> O(N) - [Best case]

import java.util.*;

public class BubbleSort {
    public static void BubbleSortAlgo(int arr[], int n) {
        for (int i=0; i<n-1; i++) {         // number of passes
            int swapped = 0;
            for (int j=0; j<n-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = 1;
                }
            }
            if (swapped == 0)
                break;
        }
    }

    // REVERSE BUBBLE SORT
    public static void ReverseBubbleSort(int arr[], int n) {
        for (int i=0; i<n-1; i++) {
            int swapped = 0;
            for (int j=0; j<n-1-i; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = 1;
                }
            }
            if (swapped == 0)
                break;
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

        BubbleSortAlgo(arr, n);
        ReverseBubbleSort(arr, n);

        // printing array
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
