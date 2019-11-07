package q350;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> l = new LinkedList();
        List<Integer> res = new ArrayList();

        for (int i = 0; i < nums1.length; i++) {
            l.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (l.contains(nums2[i])) {
                res.add(nums2[i]);
                l.remove((Object) nums2[i]);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i <res.size() ; i++) {
            ans[i] = res.get(i);
        }
        return ans;

    }
}