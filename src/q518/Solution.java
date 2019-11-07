package q518;

public class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int[] count = new int[amount + 1];
        count[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                count[i] += count[i - coin];
            }
        }
        return count[amount];
    }

    public static void main(String[] args) {
        int amount = 100;
        int[] coins = {99, 1};
        int res = new Solution().change(amount, coins);
        System.out.println(res);
    }
}
