public class CountOccurrences {
    // TC -> 2 * O(log(base 2)N)
    // SC -> O(1)
    public static int FirstOccurrence(int arr[], int x) {
        int first = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            }
            else if (arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return first;
    }
    public static int LastOccurrence(int arr[], int x) {
        int last = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1;
            }
            else if (arr[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return last;
    }
    public static int Count(int arr[], int x) {
        int first = FirstOccurrence(arr, x);
        if (first == -1) return 0;
        int last = LastOccurrence(arr, x);
        return last - first + 1;
    }

    public static void main(String args[]) {
        int arr[] = {2, 8, 8, 8, 8, 8, 11, 13};

        int count = Count(arr, 2);

        System.out.print(count);
    }
}
