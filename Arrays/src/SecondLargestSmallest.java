// BRUTE FORCE METHOD => sort the array -> arr[1] - 2nd smalllest, arr[n-2] - 2nd largest
// Time Complexity -> O(NlogN)
// Space Complexity -> O(1) - by ignoring recursion stack [if used Quick Sort]

// BETTER APPROACH => traverse the array to find largest/smallest
//                    traverse again to find 2nd largest/smallest - if (arr[i] > 2nd largest && arr[i] < largest)
//                                                                - if (arr[i] < 2nd smallest && arr[i] > smallest)
// Time Complexity -> O(2N) - two loops
// Space Complexity -> O(1)

// OPTIMAL SOLUTION =>
// Time Complexity -> O(N)
// Space COmplexity -> O(1)

public class SecondLargestSmallest {
    public static int FindSecondLargest(int arr[]) {
        int largest = arr[0];
        int secondLargest = -1;     // if -ve integers are present then better declare as Integer.MIN_VALUE
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] > secondLargest && arr[i] < largest)
                secondLargest = arr[i];
        }

        return secondLargest;
    }

    public static int FindSecondSmallest(int arr[]) {
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;

        for (int i=1; i<arr.length; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if (arr[i] < secondSmallest && arr[i] > smallest)
                secondSmallest = arr[i];
        }

        return secondSmallest;
    }

    public static void main (String args[]) {
        int arr[] = {6, 1, 4, 7, 2, 7, 5};

        int secondLargestElement = FindSecondLargest(arr);
        System.out.println(secondLargestElement);

        int secondSmallestElement = FindSecondSmallest(arr);
        System.out.println(secondSmallestElement);
    }
}
