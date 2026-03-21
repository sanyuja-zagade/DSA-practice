// Q. Search an element in the Rotated Sorted Array and return its index

public class SearchInRotatedArray {
    // BRUTE APPROACH - linear search
    // TC -> O(N)
    // SC -> O(1)
    public static int LinearSearch(int arr[], int x) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // OPTIMAL APPROACH
    // Array contains unique elements
    // TC -> O(log(base 2)N)
    // SC -> O(1)
    public static int SearchWithUniqueEle(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[low] <= arr[mid]) {    // if left part sorted
                if (arr[low] <= x && x <= arr[mid]) high = mid - 1;
                else low = mid + 1;
            }
            else {      // if right part sorted
                if (arr[mid] <= x && x <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    // Array contains duplicate elements (Binary Search algorithm is not possible for returning index)
    // TC -> O(log(base 2)N) [Average case]
    //    -> O(N/2) [near about] [Worst case - if array contains lots of duplicate ele, e.g. {3, 3, 1, 3, 3, 3, 3}]
    // SC -> O(1)
    public static boolean SearchWithDuplicateEle(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) return true;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++; high++;
                continue;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= x && x <= arr[mid]) high = mid - 1;
                else low = mid + 1;
            }
            else {
                if (arr[mid] <= x && x <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int arr[] = {4, 1, 2, 3, 3, 3, 3};

//        int index = LinearSearch(arr, 1);
//        int index = SearchWithUniqueEle(arr, 1);
        boolean index = SearchWithDuplicateEle(arr, 1);

        System.out.println(index);
    }
}
