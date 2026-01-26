// BRUTE FORCE METHOD => Sort the array -> arr[0] - smallest, arr[n-1] - largest
// Time Complexity -> O(NlogN)
// Space Complexity -> O(1) - by ignoring recursion stack [if used Quick Sort]

// OPTIMAL SOLUTION => define variable largest/smallest and compare elements with largest/smallest by retrieving array
// Time Complexity -> O(N)
// Space Complexity -> O(1)

public class LargestSmallestElement {
    public static int FindLargestElement(int arr[]) {
        int largest = arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }
        return largest;
    }

    public static int FindSmallestElement(int arr[]) {
        int smallest = arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < smallest)
                smallest = arr[i];
        }
        return smallest;
    }

    public static void main(String args[]) {
        int arr[] = {5, 2, 1, 21, 9, 6};

        int largestElement = FindLargestElement(arr);
        System.out.println(largestElement);

        int smallestElement = FindSmallestElement(arr);
        System.out.println(smallestElement);
    }
}
