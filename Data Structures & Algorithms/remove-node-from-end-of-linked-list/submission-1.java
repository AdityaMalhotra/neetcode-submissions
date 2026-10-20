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
    public ListNode removeNthFromEnd(ListNode head, int n) { //5, n=1
        int count = 0; 
        ListNode dummy = new ListNode(0); //0
        ListNode fast = dummy; //5
        ListNode slow = dummy; //5
        dummy.next = head; //5
        ListNode prev = dummy; //0
        while(fast.next!=null){
            fast=fast.next;
            count++; //1
            if(count>=n){
                slow = slow.next; //5
            }
            if(count>=n+1){
                prev=prev.next;
            }
        }
        
        ListNode temp = slow.next;
        slow.next = prev;
        prev.next = temp;

        return dummy.next;

    }
}
