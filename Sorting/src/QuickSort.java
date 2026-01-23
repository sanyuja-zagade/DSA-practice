// QUICK SORT - pick a pivot and place it at it's correct position - divide & conquer algorithm
// Rule - smaller on the left, larger on the right
// -> O(NlogN)
// -> O(N) - Space Complexity

public class QuickSort {
    public static int FindPartitionIndex(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (arr[i] <= pivot && i <= high-1)
                i++;
            while (arr[j] >= pivot && j >= low+1)
                j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
    public static void QuickSortAlgo(int arr[], int low, int high) {
        if (low < high) {
            int partition = FindPartitionIndex(arr, low, high);
            QuickSortAlgo(arr, low, partition-1);
            QuickSortAlgo(arr, partition+1, high);
        }
    }

    public static void PrintArray(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]) {
        int arr[] = {5, 6, 1, 2, 1, 3, 4};

        QuickSortAlgo(arr, 0, arr.length-1);

        PrintArray(arr);
    }
}
