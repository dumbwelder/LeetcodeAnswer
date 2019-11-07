package q31;

public class Solution {
    public void nextPermutation(int[] nums) {
        //寻找不符合降序排列的第一个数字的指针cur
        int cur = nums.length - 2;
        while (cur >= 0 && nums[cur] >= nums[cur + 1]) {
            cur--;
        }
        //将找到的数字插入到降序排列的子数组中。插入方式为，与大于该数的最小数交换。即找到字典树的下一个排列。
        if (cur != -1) {
            int val = nums[cur];
            int index = cur;
            while (index < nums.length - 1 && nums[index + 1] > val) {
                index++;
            }
            nums[cur] = nums[index];
            nums[index] = val;
        }
        //交换降序排列的数据段
        int left = cur + 1;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
