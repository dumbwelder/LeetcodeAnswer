package q125;

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!isLegal(s.charAt(start))) {
                start++;
            } else if (!isLegal(s.charAt(end))) {
                end--;
            } else {
                if (!(s.charAt(start) == s.charAt(end) || (Math.abs(s.charAt(start) - s.charAt(end)) == 32))) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            }

        }
        return true;
    }

    public static boolean isLegal(char ch) {
        if ( (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        new Solution().isPalindrome(
                "0P");
        System.out.println('0' - 'P');
    }
}