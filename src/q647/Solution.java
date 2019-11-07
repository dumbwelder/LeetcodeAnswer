package q647;

import java.util.concurrent.ForkJoinPool;

class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        char[] chs = s.toCharArray();
        int count = 0;
        boolean[][] arr = new boolean[len][len];

        for (int i = 0; i <len ; i++) {
            arr[i][i] = true;
            count++;

        }
        for (int i = 1;i<len;i++){
            if (chs[i]==chs[i-1]){
                arr[i-1][i] = true;
                count ++;
            }
        }
        for (int length =3;length<=len;length++){
            for (int i = 0; i <=len-length ; i++) {
                if (chs[i]==chs[i+length-1]&&arr[i+1][i+length-2]){
                    arr[i][i+length-1] = true;
                    count ++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        new Solution().countSubstrings("aaa");
    }
}