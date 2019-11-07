package q303;

public class Solution {

}

class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (j == i) {
            return nums[i];
        } else {
            return sumRange(i, j - 1) + nums[j];
        }
    }
}
