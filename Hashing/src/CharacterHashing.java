import java.util.*;

public class CharacterHashing {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String str = sc.next();

//        // pre-computation - for just LOWER CASE
//        int hash[] = new int[26];
//        for (int i=0; i<str.length(); i++) {
//            hash[str.charAt(i) - 'a']++;
//        }
        // pre-computation - for both LOWER CASE & UPPER CASE
        int hash[] = new int[256];
        for (int i=0; i<str.length(); i++) {
            hash[str.charAt(i)]++;
        }

        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        System.out.println("Enter queries: ");
        while (q > 0) {
            char ch = sc.next().charAt(0);

//            // fetching [Lower Case]
//            System.out.println("occurrence: " + hash[ch - 'a']);

            // fetching [both Lower & Upper Case]
            System.out.println("frequency: " + hash[ch]);

            q--;
        }
    }
}
