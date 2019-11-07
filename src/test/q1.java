package test;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//

import java.util.HashMap;
import java.util.Map;

public class q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int diff = target-nums[i];
            if (m.containsKey(diff)){
                return new int[]{m.get(diff),i};
            }
            m.put(nums[i],i);
        }

        return null;
    }
}
