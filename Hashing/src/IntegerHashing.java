import java.util.*;

public class IntegerHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        int hash[] = new int[13];   // size 13 -> last index 12 | [hash's last index is the max value in arr[]]

        System.out.println("Enter values of array: ");
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            hash[arr[i]] += 1;
        }

        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        System.out.println("Enter queries (i.e., values to be fetch): ");
        while (q>0) {
            int val = sc.nextInt();

            // fetching
            System.out.println("frequency: " + hash[val]);

            q--;
        }
    }
}
