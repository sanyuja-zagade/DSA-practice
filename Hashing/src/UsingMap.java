// Max array size:
// Inside main() --> integer - 10^6  &  boolean - 10^7
// Globally --> integer - 10^7  &  boolean - 10^8

// Therefore for integer array with the greatest element 10^9, the size of hash array will be (10^9 + 1)
// This will give - Segmentation Error

// To avoid such error - use Map
// C++ --> map, unordered map
// Java --> HashMap

// Time Complexity (for storing & fetching) -> log(N)   [for all Best, Average, Worst cases]
// Time Complexity (for unordered map) -> O(1)      [for Best & Average cases]
//                                     -> O(N)      [for Worst case]


import java.util.*;

public class UsingMap {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();    // Map<long, long> -> for keys (i.e., arr ele) such as 10^9

        System.out.println("Enter array elements: ");
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        System.out.println("Enter queries: ");
        while (q > 0) {
            int val = sc.nextInt();

            // fetching
            System.out.println("frequency: " + map.getOrDefault(val, 0));

            q--;
        }
    }
}
