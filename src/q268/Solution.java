package q268;

public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int count = (len + 1) * len / 2;
        for (int i = 0; i < len; i++) {
            count -= nums[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1};
        int res = new Solution().missingNumber(nums);
        System.out.println(res);
    }
}