import java.util.*;

public class HighestLowestFrequency {
    public static void FrequencyCounter(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxFrequency = 0, minFrequency = n;
        int maxElement = 0, minElement = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (count > maxFrequency) {
                maxFrequency = count;
                maxElement = element;
            }
            if (count < minFrequency) {
                minFrequency = count;
                minElement = element;
            }
        }

        System.out.println("Highest frequency element is: " + maxElement + "\nwith frequency: " + maxFrequency);
        System.out.println("Lowest frequency element is: " + minElement + "\nwith frequency: " + minFrequency);
    }

    public static void main(String args[]) {
        int arr[] = {3, 4, 2, 3, 2, 2, 5};
        FrequencyCounter(arr, arr.length);
    }
}
