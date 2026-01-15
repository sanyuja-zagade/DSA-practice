import static java.lang.Math.log10;
import static java.lang.Math.min;

public class Main {
    // 1.
    static int CountDigits(int n) {     // Time complexity -> O(log10(n))
        int count = 0;
        while (n != 0) {
            count++;
            n = n/10;
        }

//        int count = (int) (log10(n) + 1);     // another method

        return count;
    }

    // 2.
    static int ReverseNumber(int n) {
        int revNum = 0;
        while (n != 0) {
            int lastNum = n % 10;
            n = n / 10;

            if (revNum > Integer.MAX_VALUE/10 || (revNum == Integer.MAX_VALUE/10 && lastNum > 7))
                return 0;
            if (revNum < Integer.MIN_VALUE/10 || (revNum == Integer.MIN_VALUE/10 && lastNum < -8))
                return 0;

            revNum = revNum * 10 + lastNum;
        }
        return revNum;
    }

    // 3.
    static boolean Palindrome(int n) {
        if (n < 0)
            return false;
        int revNum = 0;
        int temp = n;
        while(n != 0) {
            int lastNum = n % 10;
            n = n / 10;

            if(revNum > Integer.MAX_VALUE/10 || (revNum == Integer.MAX_VALUE && lastNum > 7))
                return false;
            if(revNum < Integer.MIN_VALUE/10 || (revNum == Integer.MIN_VALUE && lastNum < -8))
                return false;

            revNum = revNum * 10 + lastNum;
        }
        if (revNum == temp)
            return true;
        else
            return false;
    }

    // 3. Armstrong Number [371 = 3^3 + 7^3 + 1^3 = 371]
    static int ArmstrongNum(int n) {
        int sum = 0;
        while (n != 0) {
            int lastNum = n % 10;
            sum = sum + lastNum*lastNum*lastNum;
            n /= 10;
        }
        return sum;
    }

    // 4. Print all Divisions [36 = 1,2,3,4,6,9,12,18,36] -> Time Complexity : O(N)
    static void AllDivisions(int n) {
        for (int i=1; i<=n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        // method 2  [need to sort - store in list (or vector in C++) and then sort it] -> O(sqrt(n)+nlogn+n)
        for (int i=1; i*i<=n; i++) {    // for (int i=1; i<=Math.sqrt(n); i++)
            if (n % i == 0) {
                System.out.print(i + " ");
                if (n/i != i) {
                    System.out.print(n/i + " ");
                }
            }
        }
        System.out.println();
    }

    // 5. -> O(sqrt(N))
    // Prime Number - number exactly having 2 factors, 1 and itself
    static boolean isPrime(int n) {
        if (n==1) {
            return true;
        }
        int count = 0;
        for (int i=1; i*i<=n; i++) {    // i <= sqrt(n) => i*i <= n
            if (n % i == 0) {
                count++;
                if (n/i != i){
                    count++;
                }
            }
        }
        if (count == 2)
            return true;
        else
            return false;
    }

    // GCD / HCF -> O(min(n1, n2))
    // ))
    static int GCD(int n1, int n2) {
        for (int i = Math.min(n1, n2); i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                System.out.println(i);
                break;
            }
        }
        // ******* Euclidean Algorithem ******* -> O( log(min(n1, n2)) to the base phi )
        while (n1 > 0 && n2 > 0) {
            if (n1 > n2) {
                n1 %= n2;
            } else {
                n2 %= n1;
            }
        }

        if (n1 == 0) return n2;
        return n1;
    }


    public static void main(String[] args) {
        int n = 15351;
        System.out.println(CountDigits(n));
        System.out.println(ReverseNumber(n));
        System.out.println(Palindrome(n));
        System.out.println(ArmstrongNum(371));
        AllDivisions(36);

        if (isPrime(19) == true)
            System.out.println("Number is Prime");
        else
            System.out.println("Number is Not Prime");

        System.out.println(GCD(52, 10));
    }
}