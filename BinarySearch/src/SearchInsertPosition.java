// Q. Given an sorted array with unique values and a target value.
//    If value is present in the array, then return it's index
//    Else determine the index where it would be inserted in the array while maintaining the sorted array

// It is nothing but finding the Lower Bound.

public class SearchInsertPosition {
    // TC -> O(log(base 2)N)
    public static int Solution(int arr[], int x) {
        int ans = arr.length;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 4, 7};

        int indexPosition = Solution(arr, 2);

        System.out.println(indexPosition);
    }
}
