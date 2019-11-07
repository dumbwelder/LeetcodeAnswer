package q39;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    int[] candidates;
    int target;
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.candidates = candidates;
        this.target = target;
        combinationSum(0, new Stack<Integer>(), 0);
        return res;
    }

    private void combinationSum(int cur, Stack<Integer> stack, int sum) {
        if (sum == target) {
            res.add(new LinkedList<>(stack));
        } else if (sum < target) {
            for (int i = cur; i < candidates.length; i++) {
                sum += candidates[i];
                stack.push(candidates[i]);
                combinationSum(i, stack, sum);
                stack.pop();
            }
        }
    }
}
