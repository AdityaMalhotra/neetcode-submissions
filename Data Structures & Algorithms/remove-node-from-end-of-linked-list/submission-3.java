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
        ListNode fast = dummy; //0
        ListNode slow = dummy; //0
        int count = 0;          //0

        while(fast.next!=null){ // [1]
            fast = fast.next; // 
            count++;        //   1 2 3 4
            if(count > n){  // 1> 2 2>2 
                slow = slow.next; //1 2
            }
        }

        ListNode prev = slow; //dummy
        ListNode toBeRemoved = slow.next; //head
        ListNode next = toBeRemoved.next; //null
        prev.next = next;
        return dummy.next;
    }
}
