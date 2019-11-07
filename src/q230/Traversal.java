package q230;

import java.util.Queue;
import java.util.Stack;

public class Traversal {
    public static void preTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                System.out.print(root.val + "  ");
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        System.out.println();
    }

    public static void midTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + "  ");
                root = root.right;
            }
        }
        System.out.println();
    }

    public static void postTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode r = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                if (root.right != r && root.right != null) {
                    stack.push(root);
                    root = root.right;
                } else {
                    System.out.println(root.val);
                    r = root;
                    root = null;
                }
            }
        }
        System.out.println();
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
        preTraversal(node1);
        midTraversal(node1);
        postTraversal(node1);
        int a = 1;
        int b = 2;

    }
}
