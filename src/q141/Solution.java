package q141;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur.next != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return cur == head;
    }
}
