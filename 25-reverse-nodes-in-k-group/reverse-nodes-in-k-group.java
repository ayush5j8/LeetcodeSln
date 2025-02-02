/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 1) {
        return head;
    }
    
    int len = GetTotalNodes(head);
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prevGroupEnd = dummy;

    while (len >= k) {
        ListNode curr = prevGroupEnd.next;
        ListNode prev = null;
        ListNode groupStart = curr;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        prevGroupEnd.next = prev;
        groupStart.next = curr;
        prevGroupEnd = groupStart;
        
        len -= k;
    }

    return dummy.next;
}

public int GetTotalNodes(ListNode head) {
    int count = 0;
    while (head != null) {
        count++;
        head = head.next;
    }
    return count;
}
}