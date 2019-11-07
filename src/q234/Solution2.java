package q234;

public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) fast = fast.next;
        slow = slow.next;
        ListNode prev = null;
        while (slow !=null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        while (fast!=null&&head!=null){
            if (fast.val!=head.val){
                return false;
            }else {
                fast = fast.next;
                head = head.next;
            }
        }
        return true;
    }
}
