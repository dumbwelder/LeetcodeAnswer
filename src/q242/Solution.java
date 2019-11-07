package q242;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), 1);
            } else {
                int value = m.get(s.charAt(i))+1;
                m.put(s.charAt(i), value);
            }
            if (!m.containsKey(t.charAt(i))) {
                m.put(t.charAt(i), -1);
            } else {
                int value = m.get(t.charAt(i))-1;
                m.put(t.charAt(i), value);
            }
        }
        for (int i : m.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().isAnagram("anagram","nagaram");
    }
}
