import java.util.*;

public class MapForCharacter {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }

        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        System.out.println("Enter queries: ");
        while (q > 0) {
            char ch = sc.next().charAt(0);

            System.out.println("frequency: " + map.getOrDefault(ch, 0));

            q--;
        }
    }
}
