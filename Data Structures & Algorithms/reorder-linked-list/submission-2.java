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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode toBeReversed = slow.next;
        slow.next = null; //set to null to avoid NPEs

        ListNode current = toBeReversed;
        ListNode prev = null;

        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode reversed = prev;
        ListNode normal = head;
        int i = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(reversed!=null && normal!=null){
            if(i%2 == 0){
                tail.next = normal;
                normal = normal.next;
            }else{
                tail.next = reversed;
                reversed = reversed.next;
            }
            i++;
            tail = tail.next;
        }
        tail.next = (normal!=null)? normal : reversed;
        head = dummy.next;
    }
}
