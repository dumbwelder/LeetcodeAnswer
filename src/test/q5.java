package test;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//示例 1：
//
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
//示例 2：
//
//输入: "cbbd"
//输出: "bb"
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-palindromic-substring
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class q5 {
    public static void main(String[] args) {
        System.out.println(new q5().longestPalindrome("cbabc"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] arr = new boolean[len][len];
        char[] chs = s.toCharArray();
        int max = 0;
        String str = new String();
        if(len>0){
            str = s.substring(0,1);
        }
        for (int i = 0; i < len; i++) {
            arr[i][i] = true;
            if(i<len-1&&chs[i]==chs[i+1]){
                arr[i][i+1] = true;
                str = s.substring(i, i + 2);
                max = 2;
            }
        }
        for (int length = 2; length < len; length++) {
            for (int i = 0; i < len-length ; i++) {
                if (chs[i] == chs[i+length]&&arr[i+1][i+length-1]) {
                    arr[i][i+length] = true;
                    if (max < length+1) {
                        max = length+1;
                        str = s.substring(i, i + length+1);
                    }
                }

            }
        }
        return str;
    }
}
