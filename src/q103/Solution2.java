package q103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        //数据均先压入队列，将当前节点的子节点压入队列中。使用LinkeList当前行为偶数时，输出时使用addFirst；奇数时直接输出
        q.offer(root);
        int level = 1;
        while (!q.isEmpty()) {
            int count = q.size();
            LinkedList<Integer> l = new LinkedList<>();

            for (int i = 0; i < count; i++) {
                root = q.poll();
                if (level % 2 == 1)
                    l.add(root.val);
                else l.addFirst(root.val);
                if (root.left != null) {
                    q.offer(root.left);
                }
                if (root.right != null) {
                    q.offer(root.right);
                }
            }

            res.add(l);
            level++;
        }
        return res;
    }
}
