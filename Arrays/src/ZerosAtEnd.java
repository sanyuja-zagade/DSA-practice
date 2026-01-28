// BRUTE FORCE APPROACH => copy all non-zero elements to temp array
//                         copy back those elements to original arr at 1st k places & fill the rremaining places with zero
// TC -> O(N)
// SC -> O(N) [Worst case]

// OPTIMAL SOLUTION => find 1st zero's position and keep swapping zero with +ve integers
// TC -> O(N)
// SC -> O(1)

public class ZerosAtEnd {
    public static int[] MoveZeros(int arr[]) {
        int j = -1;
        for (int i=0; i<arr.length; i++) {      // -> O(X) [X is the 1st index where zero is found]
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        for (int i=j+1; i<arr.length; i++) {    // -> O(N-X)
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        return arr;
    }

    public static void PrintArray(int arr[]) {
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String args[]) {
        int arr[] = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};

        MoveZeros(arr);

        PrintArray(arr);
    }
}
