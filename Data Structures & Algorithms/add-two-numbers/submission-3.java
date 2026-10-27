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
        // 1 2 3
        // 4 5 6 9+9 = 18. 18%10 = 8. 18/10 = 1
        //l1=[9,9,9,9,9,9,9]
        // l2=[9,9,9,9]

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while(l1!=null && l2!=null){
            int val1 = l1.val;
            int val2 = l2.val;

            int sum = val1 + val2 + carry;
            
            int result = sum%10;

            carry = sum/10;

            tail.next = new ListNode(result);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int sum = l1.val + carry;
            int result = sum%10;
            carry = sum/10;
            l1 = l1.next;
            tail.next = new ListNode(result);
            tail = tail.next;
        }
        while(l2!=null){
            int sum = l2.val + carry;
            int result = sum%10;
            carry = sum/10;
            l2 = l2.next;
            tail.next = new ListNode(result);
            tail = tail.next;
        }

        if(carry!=0){
            tail.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
