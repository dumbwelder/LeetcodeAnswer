package q230;

import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (k > 0) {
            while (root!= null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        int res = new Solution().kthSmallest(node1, 3);
        System.out.println(res);
    }
}
