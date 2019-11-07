package q19;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> s = new Stack<>();
        ListNode node = head;
        if (head.next == null) {
            return null;
        }
        while (node.next != null) {
            s.push(node);
            node = node.next;
        }
        if (n == 1) {
            node = s.pop();
            node.next = null;
        } else {
            int count = 1;
            while (count < n) {
                node = s.pop();
                count++;
            }
            node.val = node.next.val;
            node.next = node.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode res = new Solution().removeNthFromEnd(l1, 1);
        if (res != null) {
            System.out.println(res.val);
        }
    }
}