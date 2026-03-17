public class LowerUpperBound {
    // LOWER BOUND - smallest index such that arr[index] >= target value
    // TC -> O(log(base 2)N)
    public static int LowerBound(int arr[], int x) {
        int ans = arr.length;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // UPPER BOUND - smallest index such that arr[index] > target value
    // TC -> O(log(base 2)N)
    public static int UpperBound(int arr[], int x) {
        int ans = arr.length;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};

//        int ans = LowerBound(arr, 21);
        int ans = UpperBound(arr, 11);

        System.out.println(ans);
    }
}
