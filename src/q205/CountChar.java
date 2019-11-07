package q205;

import java.util.HashMap;
import java.util.Map;

public class CountChar {
    public static void main(String[] args) {
        String s1 = "afjlawdkjabljwdlknawof";
        String s2 = "egg";
        String s3 = "add";
        //countChar(s1);
        System.out.println(compare(s2, s3));
    }

    private static boolean compare(String s, String t) {
        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();
        Map<Character, Character> m = new HashMap<>();
        for (int i = 0; i < chs1.length; i++) {
            if (!m.containsKey(chs1[i])) {
                if (m.containsValue(chs2[i])) return false;
                m.put(chs1[i], chs2[i]);
            } else if (m.get(chs1[i]) != chs2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void countChar(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        for (char ch : chs) {
            if (!m.containsKey(ch)) {
                m.put(ch, 1);
            } else {
                int value = m.get(ch);
                m.put(ch, value + 1);
            }
        }
        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey() + "---" + e.getValue());
        }
    }
}
