package q55;

public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; j < len && i < len; i++) {
            if (i > j) return false;
            j = Math.max(i + nums[i], j);
        }
        return j >= len - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        boolean res = new Solution().canJump(nums);
        System.out.println(res);
    }
}
