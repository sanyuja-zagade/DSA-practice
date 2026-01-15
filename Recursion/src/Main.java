import java.util.Arrays;

public class Main {
    // 1. print n to 1 via BackTracking -> O(N)
    public static void printNum(int i, int num) {
        if (i > num)
            return;
        printNum(i+1, num);
        System.out.println(i);
    }

    //2. TC -> O(N)
    // parameterized
    public static void printSum(int num, int sum) {
        if (num == 0) {
            System.out.println(sum);
            return;
        }
        printSum(num-1, sum+num);
    }
    // functional
    public static int printsum(int num) {
        if (num == 0)
            return 0;
        return num + printsum(num-1);
    }

    // 3. TimeComplexity -> O(N)    SpaceComplexity -> O(N)
    // parameterized
    public static void factorial(int num, int fact) {
        if (num == 0){
            System.out.println(fact);
            return;
        }
        factorial(num-1, fact*num);
    }
    // functional
    public static int factorialOfNum(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorialOfNum(num-1);
    }

    // 4. TC, SC -> O(N/2)
    public static void reverseArray(int arr[], int i, int j) {
        if (i >= j)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverseArray(arr, i+1, j-1);
    }
    // method 2
    public static void arrayReverse(int i, int arr[]) {
        int n = arr.length-1;
        if (i >= (n/2))
            return;
        int temp = arr[i];
        arr[i] = arr[n-i];
        arr[n-i] = temp;
        arrayReverse(i+1, arr);
    }

    // 5. TC, SC -> O(N/2)
    public static boolean stringPalindrome(String str, int i, int j) {
        if (i >= j) return true;
        if (str.charAt(i) != str.charAt(j)) return false;
        return stringPalindrome(str, i+1, j-1);
    }

    // 6. TC ~ O(2^N)   (~ = near about)
    public static int fibonacciDigit(int n) {
        if (n <= 1) return n;
        return fibonacciDigit(n-1) + fibonacciDigit(n-2);
    }

    public static void main(String[] args) {
        // 1.
        printNum(1, 10);

        // 2.
        printSum(10, 0);
        System.out.println(printsum(10));

        // 3.
        factorial(5, 1);
        System.out.println(factorialOfNum(5));

        // 4.
        int arr[] = {2, 4, 3, 5, 1, 6};
        reverseArray(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));   // printing array

        arrayReverse(0, arr);
        for (int i=0; i<arr.length; i++) {          // printing array
            System.out.print(arr[i] + " ,");
        }
        System.out.println();

        // 5.
        String str = "Madam";
        System.out.println(stringPalindrome(str, 0, str.length()-1));

        // 6.
        System.out.println(fibonacciDigit(6));
    }
}