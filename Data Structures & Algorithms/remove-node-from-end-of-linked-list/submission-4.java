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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int count = 0;
        ListNode current = dummy;
        while(count<=n){
            current = current.next;
            count++;
        }
        ListNode prev = dummy;
        while(current!=null){
            current=current.next;
            prev = prev.next;
        }

        ListNode nth = prev.next;
        ListNode next = nth.next;
        prev.next = next;
        nth.next = null;

        return dummy.next;
    }
}
