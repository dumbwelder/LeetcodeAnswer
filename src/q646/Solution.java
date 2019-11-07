package q646;

public class Solution {
    int max = 0;

    public int findLongestChain(int[][] pairs) {
        boolean[] flag = new boolean[pairs.length];
        findLongestChain(pairs, flag, Integer.MIN_VALUE, 0);
        return max;
    }

    private void findLongestChain(int[][] pairs, boolean[] flag, int curValue, int count) {
        for (int i = 0; i < pairs.length; i++) {
            if (!flag[i] && pairs[i][0] > curValue) {
                flag[i] = true;
                findLongestChain(pairs, flag, pairs[i][1], count + 1);
                flag[i] = false;
            } else {
                max = max > count ? max : count;
            }
        }
    }

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        int res = new Solution().findLongestChain(pairs);
        System.out.println(res);
    }

}
