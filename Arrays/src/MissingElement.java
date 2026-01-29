public class MissingElement {
    // BRUTE APPROACH
    // TC -> O(N^2) it's hypothetical though, coz when you find the number in the array you broke out & inner loop doesn't run till end
    // SC -> O(1)
    public static int FindMissingValBySum(int arr[], int size) {
        for (int i=1; i<=size; i++) {
            int flag = 0;
            for (int j=0; j<size; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) return i;
        }
        return -1;
    }

    // BETTER APPROACH - initialize Hash array with zero of size (arr.length+1)
    //                   use for loop from i=0->n-1 and mark 1 at hash[arr[1]]
    //                   use for loop from i=1->n to find index with val zero - missing element
    // TC -> O(2N) -> O(N)
    // SC -> O(N)
    public static int FindMissingByHashing(int arr[], int n) {
        int hash[] = new int[n+1];
        for (int i=0; i<n-1; i++) {
            hash[arr[i]] = 1;
        }
        for (int i=1; i<=n; i++) {
            if (hash[i] == 0) return i;
        }
        return -1;
    }

    // OPTIMIZED APPROACH 1 - if array size is large (10^5), totalSum ~ 10^10 [out of int range]
    // TC -> O(N)
    // SC -> O(1)
    public static int FindMissingValByXOR(int arr[], int n) {
        int totalSum = (n*n + n)/2;
        int sum = 0;
        for (int i=0; i<n-1; i++) {
            sum += arr[i];
        }
        int missingNum = totalSum - sum;
        return missingNum;
    }

    // OPTIMIZED APPROACH 2 - using XOR [XOR will take space upto size of the array only]
    public static int FindMissingValTwo(int arr[], int n) {
        int XOR1 = 0, XOR2 = 0;
        for (int i=0; i<n-1; i++) {
            XOR1 = XOR1 ^ (i+1);
            XOR2 = XOR2 ^ arr[i];
        }
        XOR1 = XOR1 ^ n;
        return XOR1 ^ XOR2;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 4, 3};

//        int missingElement = FindMissingElement(arr, 5);
//        int missingElement = FindMissingValBySum(arr, 5);
//        int missingElement = FindMissingValByXOR(arr, 5);
        int missingElement = FindMissingByHashing(arr, 5);

        System.out.println(missingElement);
    }
}
