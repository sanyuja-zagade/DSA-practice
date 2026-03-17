// Floor --> largest number in array <= target value
// Ceil  --> smallest number in array >= target value [Lower Bound]

public class FloorAndCeil {
    // TC -> O(log(base 2)N)
    public static int Floor(int arr[], int x) {
        int ans = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return arr[ans];
    }
    public static int Ceil(int arr[], int x) {
        int ans = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                 ans = mid;
                 high = mid - 1;
            }
            else low = mid + 1;
        }
        return arr[ans];
    }

    public static void main(String args[]) {
        int arr[] = {10, 20, 25, 30, 50};

        int floor = Floor(arr, 40);
        int ceil = Ceil(arr, 40);

        System.out.println(floor + " " + ceil);
    }
}
