package q3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < chs.length; i++) {
            if (!set.contains(chs[i])) {
                set.add(chs[i]);
                count++;
                max = max > count ? max : count;
            } else {
                while (chs[left] != chs[i]) {
                    set.remove((Object) chs[left]);
                    left++;
                    count--;
                }
                left++;
            }
        }
        return max;
    }
}
