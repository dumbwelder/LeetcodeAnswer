package q162;

public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right > left) {
            int res = (left + right) / 2;
            if (nums[res] > nums[res + 1]) {
                right = res;
            } else {
                left = res + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        int res = new Solution().findPeakElement(nums);
        System.out.println(res);
    }
}
