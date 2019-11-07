package q217;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> m = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (m.contains(nums[i])){
                return true;
            }else {
                m.add(nums[i]);
            }
        }
        return false;
    }
}