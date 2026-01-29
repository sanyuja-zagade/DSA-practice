public class MaxConsecutiveOnes {
    // TC -> O(N)
    // SC -> O(1)
    public static int MaxOnesCount(int arr[]) {
        int maxCount = 0, count = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else count = 0;
        }
        return maxCount;
    }

    public static void main(String args[]) {
        int arr[] = {1, 1, 0, 1, 1, 1, 0, 1, 1};

        int maxOnes = MaxOnesCount(arr);

        System.out.println(maxOnes);
    }
}
