package q103;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        //使用一个队列来实现队列的功能（顺序输出），一个栈实现逆转的功能（逆序输出）
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        //数据均先压入队列，将当前节点的子节点压入队列中。当前行为偶数时，输出时先将数据压入s,再弹出；奇数时直接输出
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> l = new ArrayList<>();
            if (level % 2 == 1) {
                for (int i = 0; i < count; i++) {
                    root = q.poll();
                    l.add(root.val);
                    if (root.left != null) {
                        q.offer(root.left);
                    }
                    if (root.right != null) {
                        q.offer(root.right);
                    }
                }
            } else {
                for (int i = 0; i < count; i++) {
                    root = q.poll();
                    s.push(root.val);
                    if (root.left != null) {
                        q.offer(root.left);
                    }
                    if (root.right != null) {
                        q.offer(root.right);
                    }
                }
                for (int i = 0; i < count; i++) {
                    l.add(s.pop());
                }
            }
            res.add(l);
            level++;
        }
        return res;
    }
}
