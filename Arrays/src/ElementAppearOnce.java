public class ElementAppearOnce {
    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(1);
    public static int FindNumAppearOnceBrute(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            int count = 0;
            for (int j=0; j<arr.length; j++) {
                if (arr[i] == arr[j]) count++;
            }
            if (count == 1) return arr[i];
        }
        return -1;
    }

    // BETTER APPROACH - using Hashing
    // TC -> O(3N)
    // SC -> O(maxElement) [depends on user input]
    public static int FindNumAppearOnceBetter(int arr[]) {
        int maxElement = arr[0];
        for (int i=0; i<arr.length; i++)
            maxElement = Math.max(maxElement, arr[i]);

        int hash[] = new int[maxElement+1];
        for (int i=0; i<arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i=0; i<arr.length; i++) {
            if (hash[arr[i]] == 1)
                return arr[i];
        }

        return -1;
    }

    // OPTIMAL SOLUTION - using XOR
    // TC -> O(N)
    // SC -> O(1)
    public static int FindNumAppearOnce(int arr[]) {
        int XOR = 0;
        for (int i=0; i<arr.length; i++) {
            XOR ^= arr[i];
        }
        return XOR;
    }

    public static void main(String args[]) {
        int arr[] = {1, 1, 2, 5, 2, 4, 4};

//        int num = FindNumAppearOnce(arr);
//        int num = FindNumAppearOnceBrute(arr);
        int num = FindNumAppearOnceBetter(arr);

        System.out.println(num);
    }
}
