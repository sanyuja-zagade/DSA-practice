// Q. Check if they given string s is equal to string goal, if s is rotated

public class CanRotateToGoal {
    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(N) [to store rotated string]
    public static boolean RotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        for (int i=0; i<s.length(); i++) {
            String rotatedStr = s.substring(i) + s.substring(0, i);
            if (rotatedStr.equals(goal)) return true;
        }
        return false;
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(N) [space used by newStr]
    public static boolean RotateStringOptimal(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String newStr = s + s;
        if (newStr.contains(goal)) return true;
        return false;
    }

    public static void main(String args[]) {
        String s = "rotation", goal = "tionrota";

//        System.out.println(RotateString(s, goal));
        System.out.println(RotateStringOptimal(s, goal));
    }
}
