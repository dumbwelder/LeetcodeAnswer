package q46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> l = new LinkedList();
        for (int i : nums) {
            l.add(i);
        }
        List<Integer> result = new ArrayList<>();
        int len = l.size();
        per(result, l);
        return res;
    }

    public void per(List<Integer> result, List<Integer> l) {
        if (l.size() == 0) {
            res.add(result);
        } else {
            for (int i = 0; i < l.size(); i++) {
                List<Integer> res = new ArrayList<Integer>(result);
                res.add(l.get(i));
                List<Integer> ll = new ArrayList<Integer>(l);
                ll.remove(i);
                per(res, ll);
            }
        }
    }
}
