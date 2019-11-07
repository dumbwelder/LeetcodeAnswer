package q6;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        int unit;
        if (numRows > 2) {
            unit = numRows * 2 - 2;
        } else {
            unit = numRows;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j += unit) {
                if (j + i < s.length()) {
                    res.append(s.charAt(j + i));
                }
                if (i > 0 && i < numRows - 1) {
                    if (j + unit - i < s.length()) {
                        res.append(s.charAt(j + unit - i));
                    }
                }
            }
        }
        return res.toString();
    }
    public String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert1("LEETCODEISHIRING", 3));
    }
}
