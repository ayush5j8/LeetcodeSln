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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode res = new ListNode(-1);
        ListNode iter = res;
        int carry = 0, sum = 0;
        while(temp1 != null && temp2 != null){
            sum = temp1.val + temp2.val + carry;
            int digit = sum%10;
            carry = sum/10;
            ListNode temp3 = new ListNode(digit);
            iter.next = temp3;
            iter = iter.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // if my first linkedlist got exhausted i.e., len(l1)<len(l2)
        if(temp1 == null){
            while(temp2 != null){
                sum = temp2.val + carry;
                int digit = sum%10;
                carry = sum/10;
                ListNode temp3 = new ListNode(digit);
                iter.next = temp3;
                iter = iter.next;
                temp2 = temp2.next;
            }
        }

        // if my second linkedlist got exhausted i.e., len(l2)<len(l1)
        if(temp2 == null){
            while(temp1 != null){
                sum = temp1.val + carry;
                int digit = sum%10;
                carry = sum/10;
                ListNode temp3 = new ListNode(digit);
                iter.next = temp3;
                iter = iter.next;
                temp1 = temp1.next;
            }
        }

        // what if I have a carry left at the end
        if(carry != 0){
            ListNode temp3 = new ListNode(carry);
            iter.next = temp3;
        }

        return res.next;
    }
}