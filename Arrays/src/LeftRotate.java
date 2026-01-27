public class LeftRotate {
    // Rotate by one place
    // TC -> O(N)
    // SC -> O(1)
    public static int[] RotateByOnePlace(int arr[]) {
        int temp = arr[0];
        for (int i=1; i<arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;

        return arr;
    }

    // left rotate the array by k places - BRUTE FORCE APPROACH
    // TC -> O(N+d) -> O(N)
    // SC -> O(d)
    public static int[] RotateLeftBrute(int arr[], int pos) {
        int temp[] = new int[arr.length];
        int n = arr.length;
        int d = pos % n;

        for (int i=0; i<d; i++)        // -> O(d)
            temp[i] = arr[i];
        for (int i=d; i<n; i++)        // -> O(d)
            arr[i-d] = arr[i];
        for (int i=n-d; i<n; i++)      // -> O(n-d)
            arr[i] = temp[i-(n-d)];

        return arr;
    }

    // OPTIMAL SOLUTION - no extra space, though time complexity is slightly greater
    // TC -> O(2N) -> O(N)
    // SC -> O(1)
    public static void ReverseArray(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static int[] RotateLeftOptimal(int arr[], int pos) {
        if (arr.length == 0 || pos == 0) return arr;

        int d = pos % arr.length;
        ReverseArray(arr, 0, d-1);          // -> O(d)
        ReverseArray(arr, d, arr.length-1);      // -> O(n-d)
        ReverseArray(arr, 0, arr.length-1); // -> O(n)

        return arr;
    }

    public static void printArray(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main (String args[]) {
        int arr[] = {1, 2, 3, 4, 5};

//        RotateByOnePlace(arr);
//        RotateLeftBrute(arr, 3);
        RotateLeftOptimal(arr, 3);

        printArray(arr);
    }
}
