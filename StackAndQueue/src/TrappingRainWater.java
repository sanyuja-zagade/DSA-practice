public class TrappingRainWater {
    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(1)
    public static int TrapWaterBrute(int[] heights) {
        int waterTrapped = 0;
        for (int i=0; i<heights.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j=0; j<=i; j++) {
                leftMax = Math.max(leftMax, heights[j]);
            }
            for (int j=i; j<heights.length; j++) {
                rightMax = Math.max(rightMax, heights[j]);
            }
            waterTrapped += Math.min(leftMax, rightMax) - heights[i];
        }
        return waterTrapped;
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static int TrapWaterOptimal(int[] heights) {
        int waterTrapped = 0;
        int left = 0;
        int right = heights.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (heights[left] <= heights[right]) {
                if (heights[left] >= leftMax) leftMax = heights[left];
                else waterTrapped += leftMax - heights[left];
                left++;
            }
            else {
                if (heights[right] >= rightMax) rightMax = heights[right];
                else waterTrapped += rightMax - heights[right];
                right--;
            }
        }
        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] buildingHeights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

//        System.out.println(TrapWaterBrute(buildingHeights));
        System.out.println(TrapWaterOptimal(buildingHeights));
    }
}
