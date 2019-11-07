package q334;

public class Solution2 {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        //b为最小，a为倒数第二小。
        int a = Integer.MAX_VALUE;
        int b = nums[0];
        int count = 1;
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (count == 2 && nums[i] > a) {
                return true;
            } else if (nums[i] > nums[flag] && nums[i] < a) {
                a = nums[i];
                count = 2;
                b = nums[flag];
            } else if (nums[i] < nums[flag]) {
                flag = i;
            }
        }
        return false;
    }
}
