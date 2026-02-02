// Q. Sort an array of 0's 1's & 2's

public class DutchNationalFlag {
    // BRUTE APPROACH - using Merge Sort
    // TC -> O(NlogN)
    // SC -> O(N)

    // BETTER APPROACH
    // TC -> O(2N)
    // SC -> O(1)
    public static int[] SortZerosOnesTwos(int arr[]) {
        int zeros = 0, ones = 0, twos = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 0) zeros++;
            if (arr[i] == 1) ones++;
            if (arr[i] == 2) twos++;
        }
        for (int i=0; i<arr.length; i++) {
            if (i < zeros) arr[i] = 0;
            else if (i >= zeros && i < zeros+ones) arr[i] = 1;
            else arr[i] = 2;
        }

        return arr;
    }

    // OPTIMAL APPROACH - Dutch National Flag Algorithm | Three Colors Algorithm
    //                    4 rules : 0 -> low-1   => zeros
    //                            : low -> mid-1 => ones
    //                            : mid -> high  => unsorted part
    //                            : high -> n-1  => twos
    // TC -> O(N)
    // SC -> O(1)
    public static int[] DutchFlag(int arr[]) {
        int low = 0, mid = 0, high = arr.length-1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++; mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }

        return arr;
    }

    public static void main (String args[]) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 2};

//        int[] sortedArray = SortZerosOnesTwos(arr);
        int[] sortedArray = DutchFlag(arr);

        for (int ele : sortedArray) System.out.print(ele + " ");
    }
}
