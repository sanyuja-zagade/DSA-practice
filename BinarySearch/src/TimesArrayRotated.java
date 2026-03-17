// TC -> O(log(base 2)N)
// SC -> O(1)

public class TimesArrayRotated {
    // Array contains unique elements
    public static int OptimalSolution(int arr[]) {
        int index = -1;
        int minELe = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[low] <= arr[high]) {
                index = low;
                break;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] < minELe) {
                    minELe = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            else {
                if (arr[mid] < minELe) {
                    minELe = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }

    // Array contains duplicate elements
    public static int OptimalForDuplicates(int arr[]) {
        int index = -1;
        int minEle = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                if (arr[low] < minEle) {
                    minEle = arr[low];
                    index = low;
                }
                low++; high--;
                continue;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] < minEle) {
                    minEle = arr[low];
                    index = low;
                }
                low = mid + 1;
            }
            else {
                if (arr[mid] < minEle) {
                    minEle = arr[mid];
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        int arr[] = {1, 1, 2, 2, 2};

//        int index = OptimalSolution(arr);
        int index = OptimalForDuplicates(arr);

        System.out.println(index);
    }
}
