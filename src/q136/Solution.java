package q136;

import sun.security.util.Length;

import java.time.OffsetDateTime;
import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-1 ; i=i+2) {
            if (nums[i]!=nums[i+1])
                return nums[i];
        }
        return nums[nums.length-1];
    }
}