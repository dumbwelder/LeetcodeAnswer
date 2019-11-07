package q234;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        List<Integer> l = new ArrayList<>();
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = l.size() - 1;
        while (start < end) {
            if (!l.get(start).equals(l.get(end))) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;

    }
}
