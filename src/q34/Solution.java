package q34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int leftIndex = extremeInsertionIndex(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return res;
        }
        res[0] = leftIndex;
        res[1] = extremeInsertionIndex(nums, target, false) - 1;
        return res;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean flag) {
        int low = 0;
        //解决数组长度为1的情况，需要配合循环条件更改
        int high = nums.length;
        //该循环能取到的所有值：low~high；找不到时最后返回0~nums.length
        while (low < high) {
            //mid值在区间长度为2时，为low的值
            int mid = (low + high) / 2;
            //mid值大于目标时，上界左移；mid值小于目标时，下界右移；
            //寻找左边界和右边界的区别：在寻找到相等的值时，需要左边界时则上界左移,最后high值为；需要右边界时下界右移
            //问题：如何保证一定能够找到：保证在该区间内始终有一个相等值
            if (nums[mid] > target || (flag && target == nums[mid])) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(new Solution().searchRange(nums, target));
    }
}
