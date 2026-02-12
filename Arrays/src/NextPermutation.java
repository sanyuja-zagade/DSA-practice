public class NextPermutation {
    // BRUTE APPROACH - find all the possible permutations and store them in a sorted manner
    //                  return the next permutation of the given one
    //                  if the given one is the last, return first permutation
    // TC -> O(N! * N) [N! - generating permutations | N - size of each permutation]
    // SC -> O(N!)     [to store all permutations]
    //
    // if no. of ele = 15 --> no. of permutations ~ 10^12 --> Brute approach not feasible


    // OPTIMAL APPROACH
    // TC -> O(N) [breaking point is found & sub-array is reversed linearly]
    // SC -> O(1)
    public static int[] NextPermutationOptimal(int arr[]) {
        int index = -1;
        for (int i=arr.length-1; i>0; i--) {
            if (arr[i-1] < arr[i]) {
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            ReverseArray(arr, 0, arr.length - 1);
            return arr;
        }
        for (int i=arr.length-1; i>index; i--) {
            if (arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }
        ReverseArray(arr, index+1, arr.length-1);

        return arr;
    }

    public static void ReverseArray(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
    }

    public static void main(String args[]) {
        int arr[] = {5, 4, 3, 2, 1};

        int[] nextPermutation = NextPermutationOptimal(arr);

        for (int ele : nextPermutation) System.out.print(ele + " ");
    }
}
