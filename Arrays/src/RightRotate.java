public class RightRotate {
    // Rotate by one place
    // TC -> O(N)
    // SC -> O(1)
    public static int[] RotateByOnePlace(int arr[]) {
        int temp = arr[arr.length - 1];
        for (int i=arr.length-1; i>0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;

        return arr;
    }

    // Rotate by k places - BRUTE FORCE APPROACH
    // TC -> O(N+d) -> O(N)
    // SC -> O(d)
    public static int[] RotateRightBrute(int arr[], int pos) {
        int temp[] = new int[arr.length];
        int n = arr.length;
        int d = pos % n;

        for (int i=n-d; i<n; i++)       // -> O(n-d)
            temp[i-(n-d)] = arr[i];
        for (int i=n-1; i>=d; i--)      // -> O(d)
            arr[i] = arr[i-d];
        for (int i=0; i<d; i++)         // -> O(d)
            arr[i] = temp[d-1-i];

        return arr;
    }

    // OPTIMAL SOLUTION
    // TC -> O(2N-d) -> O(N)
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
    public static int[] RotateRightOptimal(int arr[], int pos) {
        int n = arr.length;
        if (n == 1 || pos == 0) return arr;

        int d = pos % n;
        ReverseArray(arr, 0, n-1-d);    // -> O(n-d)
        ReverseArray(arr, 0, n-1);      // -> O(n)

        return arr;
    }

    public static void PrintArray(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main (String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};

//        RotateByOnePlace(arr);
//        RotateRightBrute(arr, 3);
        RotateRightOptimal(arr, 3);

        PrintArray(arr);
    }
}
