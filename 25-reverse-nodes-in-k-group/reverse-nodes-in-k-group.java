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
        // Recursive Approach
        // Let's write code for reverse and then modify the same
        // Let's count total Nodes

        int count = 0;
        ListNode prev = head;
        while(prev != null){
            prev = prev.next;
            count++;
        }
        return helper(head, k, count);
    }

    public ListNode helper(ListNode main, int k , int count){
        if(main == null || k > count)
        return main;

        ListNode prev = null;
        ListNode curr = main;
        int p = k;
        while(curr != null && p-- > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        main.next = helper(curr, k, count-k);
        return prev;
    }
}