package q387;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Character> l = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                l.add(s.charAt(i));
            } else {
                l.remove((Object)s.charAt(i));
            }
        }
        if (l.size() > 0) {
            return map.get(l.get(0));
        }else return -1;
    }

    public static void main(String[] args) {
        new Solution().firstUniqChar("loveleetcode");
    }
}
