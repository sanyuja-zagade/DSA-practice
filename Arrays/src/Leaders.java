// Leader - all the elements present on its right side are smaller

import java.util.ArrayList;
import java.util.List;

public class Leaders {
    // BRUTE APPROACH
    // TC ~ O(N^2)
    // SC -> O(N) [Worst case] [space used only for storing/returning, and not to solve]
    public static List<Integer> LeadersInArrayBrute(int arr[]) {
        List<Integer> leaders = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            boolean isLeader = true;
            for (int j=i; j<arr.length; j++) {
                if (arr[i] < arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader == true)
                leaders.add(arr[i]);
        }

        return leaders;
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(N) [Worst case] [space used only for storing/returning, and not to solve]
    public static List<Integer> LeadersInArrayOptimal(int arr[]) {
        List<Integer> leaders = new ArrayList<>();
        int maxEle = Integer.MIN_VALUE;
        for (int i=arr.length-1; i>=0; i--) {
            if (arr[i] > maxEle) {
                maxEle = arr[i];
                leaders.add(maxEle);
            }
        }

        return leaders;
    }

    public static void main(String args[]) {
        int arr[] = {10, 22, 12, 3, 0, 6};

//        List<Integer> allLeaders = LeadersInArrayBrute(arr);
        List<Integer> allLeaders = LeadersInArrayOptimal(arr);

        for (int leader : allLeaders) System.out.print(leader + " ");
    }
}
