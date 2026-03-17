public class MinimumInRotatedArray {
    // BRUTE APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static int BruteSolution(int arr[]) {
        int minEle = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            minEle = Math.min(minEle, arr[i]);
        }
        return minEle;
    }

    // OPTIMAL APPROACH
    // Array contains unique elements
    // TC -> O(log(base 2)N)
    // SC -> O(1)
    public static int OptimalSolution(int arr[]) {
        int minELe = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[low] <= arr[high]) {    // if whole search space is sorted - arr[low] will be minimum
                minELe = Math.min(minELe, arr[low]);
                break;
            }
            if (arr[low] <= arr[mid]) {    // if left is sorted - pick smallest ele and search smallest in unsorted part (right)
                minELe = Math.min(minELe, arr[low]);
                low = mid + 1;
            }
            else {      // if left is sorted - pick smallest ele and search smallest in unsorted part (right)
                minELe = Math.min(minELe, arr[mid]);
                high = mid - 1;
            }
        }
        return minELe;
    }

    // Array contains duplicate elements
    // TC -> O(log(base 2)N)
    // SC -> O(1)
    public static int OptimalForDuplicates(int arr[]) {
        int minEle = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                minEle = Math.min(minEle, arr[low]);
                low++; high--;
                continue;
            }
            if (arr[low] <= arr[mid]) {
                minEle = Math.min(minEle, arr[low]);
                low = mid + 1;
            }
            else {
                minEle = Math.min(minEle, arr[mid]);
                high = mid - 1;
            }
        }
        return minEle;
    }

    public static void main(String args[]) {
        int arr[] = {2, 1, 2, 2, 2};

//        int minimum = BruteSolution(arr);
//        int minimum = OptimalSolution(arr);
        int minimum = OptimalForDuplicates(arr);

        System.out.println(minimum);
    }
}
