package q646;

import java.util.Arrays;

public class Solution2 {
    public int findLongestChain(int[][] pairs) {
        if (pairs==null||pairs.length==0) return 0;
        //记录以第i个数结尾的最长
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs, (o1, o2) -> {
            int flag = o1[0] - o2[0];
            return flag;
        });
        int max = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

    //[[-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]]
    public static void main(String[] args) {
        int[][] pairs = {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
        int res = new Solution2().findLongestChain(pairs);
        System.out.println(res);
    }
}
