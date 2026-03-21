public class FindPeakElement {
    // BRUTE APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static int BruteSolution(int arr[]) {
        if (arr.length == 1) return 0;
        for (int i=0; i<arr.length; i++) {
            if ((i == 0 || arr[i-1] < arr[i]) && (i == arr.length-1 || arr[i] > arr[i+1]))
                return i;
        }
        return -1;
    }

    // OPTIMAL APPROACH
    // TC -> O(log(base 2)N)
    // SC -> O(1)

    // For a single peak
    public static int OptimalSolution(int arr[]) {
        if (arr.length == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[arr.length-1] > arr[arr.length-2]) return arr.length-1;

        int low = 1, high = arr.length-2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if (arr[mid] > arr[mid-1]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // If multiple peaks exist
    public static int Solution(int arr[]) {
        if (arr.length == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[arr.length-1] > arr[arr.length-2]) return arr.length-1;

        int low = 1, high = arr.length-2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if (arr[mid] > arr[mid-1]) low = mid + 1;
            else if (arr[mid] > arr[mid+1]) high = mid - 1;
            else low = mid + 1;   // if mid is at bottom (arr[mid-1] > arr[mid] < arr[mid+1]) ==> can go to either left OR right part
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 9, 3, 7, 6, 5};

        int peakIndex = BruteSolution(arr);
//        int peakIndex = OptimalSolution(arr);
//        int peakIndex = Solution(arr);

        System.out.println(peakIndex);
    }
}
