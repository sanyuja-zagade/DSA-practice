import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayBySign {
    // if in the given array positive elements = negative elements

    // BRUTE APPROACH
    // TC -> O(N + N/2)
    // SC -> O(N)
    public static int[] RearrangeArrayBrute(int arr[]) {
        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > 0)
                positiveList.add(arr[i]);
            else
                negativeList.add(arr[i]);
        }
        for (int i=0; i<arr.length/2; i++) {
            arr[2*i] = positiveList.get(i);
            arr[2*i+1] = negativeList.get(i);
        }
        return arr;
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(N)
    public static int[] RearrangeArrayOptimal(int arr[]) {
        int temp[] = new int[arr.length];
        int positiveIndex = 0, negativeIndex = 1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > 0) {
                temp[positiveIndex] = arr[i];
                positiveIndex += 2;
            }
            else {
                temp[negativeIndex] = arr[i];
                negativeIndex += 2;
            }
        }

        return temp;
    }

    // if in the given array positive elements != negative elements

    // TC -> O(2N)
    // SC -> O(N)
    public static int[] RearrangeArray(int arr[]){
        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();

        for (int i=0; i<arr.length; i++) {
            if (arr[i] > 0)
                positiveList.add(arr[i]);
            else
                negativeList.add(arr[i]);
        }

        int minLen = Math.min(positiveList.size(), negativeList.size());
        for (int i=0; i<minLen; i++) {
            arr[2*i] = positiveList.get(i);
            arr[2*i+1] = negativeList.get(i);
        }

        int index = minLen * 2;
        if (positiveList.size() > negativeList.size()) {
            for (int i=minLen; i<positiveList.size(); i++) {
                arr[index] = positiveList.get(i);
                index++;
            }
        }
        else {
            for (int i=minLen; i<negativeList.size(); i++) {
                arr[index] = negativeList.get(i);
                index++;
            }
        }

        return arr;
    }

    public static void main (String args[]) {
        int arr[] = {3, 1, -2, -5, 2, -4, -3, -6};

//        int[] rearrangedArr = RearrangeArrayBrute(arr);
//        int[] rearrangedArr = RearrangeArrayOptimal(arr);
        int[] rearrangedArr = RearrangeArray(arr);

        for (int ele : rearrangedArr) System.out.print(ele + " ");
    }
}
