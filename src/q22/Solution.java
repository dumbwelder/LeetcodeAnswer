package q22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n != 0) {
            parenthesis("", n , n );
        }
        return res;
    }

    private void parenthesis(String s, int m, int n) {
        if (n == 0 && m == 0) {
            res.add(s + ")");
        }
        if (m > 0) {
            parenthesis(s + "(", m - 1, n);
        }
        if (m < n ) {
            parenthesis(s + ")", m, n - 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = new Solution().generateParenthesis(3);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
