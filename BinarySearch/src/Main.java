// Binary Search is applicable to a sorted search space only

// Overflow Case : if search space is from 0 -> Integer.MAX_VALUE
//                 if val is around Integer.MAX_VALUE => long long low, long long high
//                                                    => mid = low + [(high - low) / 2]

public class Main {
    // Iterative
    // TC -> O(log(base 2)N)
    // SC -> O(1)
    public static int BinarySearchIterative(int arr[], int val) {
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == val) return mid;
            else if (arr[mid] > val) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    // Recursive
    // TC -> O(log(base 2)N)
    // SC -> O(log(base 2)N) [if considered Recursive Stack]
    //    -> O(1) [Otherwise]
    public static int BinarySearchRecursive(int arr[], int low, int high, int val) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == val) return mid;
        else if (arr[mid] > val) return BinarySearchRecursive(arr, low, mid-1, val);
        return BinarySearchRecursive(arr, mid+1, high, val);
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 6, 7, 9, 12, 16, 17};

//        int index = BinarySearchIterative(arr, 12);
        int index = BinarySearchRecursive(arr, 0, arr.length-1, 13);

        System.out.println(index);
    }
}