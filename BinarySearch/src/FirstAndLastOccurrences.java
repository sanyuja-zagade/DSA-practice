// Q. Return indices of first and last occurrences of a given number in a sorted array

public class FirstAndLastOccurrences {
    // BRUTE APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static int[] BruteSolution(int arr[], int x) {
        int first = -1, last = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == x) {
                if (first == -1) first = i;
                last = i;
            }
        }
        return new int[] {first, last};
    }

    // OPTIMAL APPROACH - using Lower & Upper Bound
    // TC -> 2 * O(log(base 2)N)
    // SC -> O(1)
    public static int LowerBound(int arr[], int x) {
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
    public static int[] OptimalSolution(int arr[], int x) {
        int lb = LowerBound(arr, x);
        if (lb == arr.length || arr[lb] != x) return new int[] {-1, -1};
        return new int[] {lb, UpperBound(arr, x) - 1};
    }

    // OPTIMAL APPROACH - using plain Binary Search
    // TC -> 2 * O(log(base 2)N)
    // SC -> O(1)
    public static int FirstOccurrence(int arr[], int x) {
        int first = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                first = mid;
                high = high - 1;
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
    public static int[] FirstAndLast(int arr[], int x) {
        int first = FirstOccurrence(arr, x);
        if (first == -1) return new int[] {-1, -1};
        int last = LastOccurrence(arr, x);
        return new int[] {first, last};
    }

    public static void main(String args[]) {
        int arr[] = {2, 8, 8, 8, 8, 8, 11, 13};

//        int firstAndLast[] = BruteSolution(arr, 5);
//        int firstAndLast[] = OptimalSolution(arr, 6);
        int firstAndLast[] = FirstAndLast(arr, 6);

        for (int index : firstAndLast) System.out.print(index + " ");
    }
}
