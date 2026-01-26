// Time Complexity -> O(N)
// Space Complexity -> O(1)

public class CheckSorted {
    public static boolean isArraySorted (int arr[]) {
        boolean isSorted = true;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }

    public static void main (String args[]) {
        int arr[] = {1, 2, 2, 4, 3, 4, 5};

        boolean arraySorted = isArraySorted(arr);
        System.out.println(arraySorted);
    }
}
