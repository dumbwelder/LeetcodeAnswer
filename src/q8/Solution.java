package q8;

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        int res = 0;
        if (str == null || str.length() == 0) return 0;
        char firstChar = str.charAt(0);
        if (!isLegalStart(firstChar)) {
            return 0;
        } else if (firstChar == '+' || firstChar == '-') {
            str = str.substring(1);
        }
        boolean flag = true;
        if (firstChar == '-') {
            flag = false;
        }
        for (int i = 0; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
            int value = str.charAt(i) - '0';
            if (flag && (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && value > 7))) {
                return Integer.MAX_VALUE;
            } else if (!flag && (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && value > 8)))
                return Integer.MIN_VALUE;
            res = res * 10 + value;
        }
        if (!flag) {
            res = -res;
        }
        return res;
    }

    public static boolean isLegalStart(char ch) {
        return ch == '+' || ch == '-' || (ch >= '0' && ch <= '9');
    }

    public static void main(String[] args) {
        String str = "-922337203685477580711";
        System.out.println(new Solution().myAtoi(str));
        System.out.println(Long.MAX_VALUE);
    }
}
