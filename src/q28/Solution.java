package q28;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        else if (haystack.length() == 0) return -1;

        if (haystack.length() < needle.length()) return -1;
        char first = needle.charAt(0);
        int max = haystack.length() - needle.length();
        for (int i = 0; i <=max; i++) {
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first) ;
            }
            if (i <= max) {
                int j = i + 1;
                int end = j + needle.length() - 1;
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++) ;
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "a";
        System.out.println(str1.length());
        System.out.println(new Solution().strStr(str1, str2));
    }
}
