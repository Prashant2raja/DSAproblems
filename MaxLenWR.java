package TCSnqt;
import java.util.*;
public class MaxLenWR {
    public static void main(String[] args) {
        String s = "bbbb";

        int left  = 0 , right = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while(right < s.length()) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
                right++;

            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        System.out.println("Max len is " + max);
    }
}
