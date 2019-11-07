package q2;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        int value = 0;
        ListNode res = new ListNode(0);
        ListNode ans = res;
        while (l1 != null && l2 != null) {
            value = (l1.val + l2.val + flag) % 10;
            flag = (l1.val + l2.val + flag) / 10;
            res.next = new ListNode(value);
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }
        if (l1 != null) {
            while (flag == 1 && l1 != null) {
                flag = (l1.val + flag) / 10;
                l1.val = (l1.val + flag) % 10;
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }
        } else if (l2 != null) {
            while (flag == 1 && l2 != null) {
                flag = (l2.val + flag) / 10;
                l2.val = (l2.val + flag) % 10;
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
        }
        if (flag == 1) {
            res.next = new ListNode(1);
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(2);
        l2.next = l3;
        l3.next = l4;
        ListNode res = new Solution().addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
