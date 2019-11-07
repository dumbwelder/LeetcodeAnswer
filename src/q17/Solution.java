package q17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    List<String> res = new ArrayList<>();
    Map<String, String> m = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return res;
    }

    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            res.add(combination);
        } else {
            String key = next_digits.substring(0, 1);
            String digits = next_digits.substring(1);
            String v = m.get(key);
            for (int i = 0; i < v.length(); i++) {
                backtrack(combination + v.charAt(i), digits);
            }
        }
    }


    public static void main(String[] args) {
        List<String> res = new Solution().letterCombinations("23");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
