package q322;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    if (count[(i - coins[j])] == Integer.MAX_VALUE) continue;
                    min = Math.min(min, count[(i - coins[j])] + 1);
                }
            }
            count[i] = min;
        }

        return (count[amount] == Integer.MAX_VALUE) ? -1 : count[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(new Solution().coinChange(coins, amount));
    }
}
