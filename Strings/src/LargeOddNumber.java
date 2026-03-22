public class LargeOddNumber {
    // TC -> O(N)
    // SC -> O(1)
    public static String FindLargeOddNum(String s) {
        int index = -1;
        for (int i=s.length()-1; i>=0; i--) {
            if ((s.charAt(i) - '0') % 2 != 0) {
                index = i;
                break;
            }
        }

        if (index == -1) return "";

        int i = 0;
        while (i <= index && s.charAt(i) == '0') i++;

        return s.substring(i, index + 1);
    }

    public static void main(String args[]) {
        String s = "054326768";

        String largeOddSubString = FindLargeOddNum(s);

        System.out.println(largeOddSubString);
    }
}
