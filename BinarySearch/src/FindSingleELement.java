public class FindSingleELement {
    // BRUTE APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static int BruteSolution(int arr[]) {
        if (arr.length == 1) return arr[0];
        for (int i=0; i<arr.length; i++) {
            if (i == 0) {
                if (arr[i] != arr[i+1]) return arr[i];
            }
            else if (i == arr.length-1) {
                if (arr[i] != arr[i-1]) return arr[i];
            }
            else {
                if (arr[i] != arr[i-1] && arr[i] != arr[i+1]) return arr[i];
            }
        }
        return -1;
    }

    // OPTIMAL APPROACH
    // (even, odd) --> left part don't have single element --> eliminate left part
    // (odd, even) --> right part don't have single element --> eliminate right part
    // TC -> O(log(base 2)N)
    // SC -> O(1)
    public static int OptimalSolution(int arr[]) {
        if (arr.length == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[arr.length-1] != arr[arr.length-2]) return arr[arr.length-1];

        int low = 1, high = arr.length-2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) return arr[mid];

            if ((mid % 2 != 0 && arr[mid-1] == arr[mid]) || (mid % 2 == 0 && arr[mid+1] == arr[mid])) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};

//        int singleEle = BruteSolution(arr);
        int singleEle = OptimalSolution(arr);

        System.out.println(singleEle);
    }
}
