package q322;

import java.util.Arrays;

public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        Arrays.fill(count, amount + 1);
        count[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                count[i] = Math.min(count[i], count[i - coin] + 1);
            }
        }

        return (count[amount + 1] == amount + 1) ? -1 : count[amount + 1];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(new Solution().coinChange(coins, amount));
    }
}
