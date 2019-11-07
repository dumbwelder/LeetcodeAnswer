package q190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res = res | (n & 1);
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new Solution().reverseBits(-1);
        System.out.println(i);
    }
}
