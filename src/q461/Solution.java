package q461;

public class Solution {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((res & 1) == 1) {
                count++;
            }
            res = res >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int res = new Solution().hammingDistance(1, 1);
        System.out.println(res);
        System.out.println(1^1);
    }
}
