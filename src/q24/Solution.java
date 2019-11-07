package q24;

public class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode res = new ListNode(0);
        res.next = head;

        ListNode pre = res;
        ListNode next;
        ListNode cur = head;

        while (cur != null && cur.next != null) {

            next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
    }
}
