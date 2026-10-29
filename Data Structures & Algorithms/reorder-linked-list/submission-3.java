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
        // [2,4,6,8,10]
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode current = slow.next; //8
        slow.next = null;

        ListNode prev = null;
        while(current!=null){
            ListNode next = current.next; //null
            current.next = prev; //10->8-> null
            prev = current; //8 //10
            current = next; //10
        }

        ListNode head2 = prev;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(head!=null && head2!=null){
            tail.next = head;
            tail = tail.next;
            head = head.next;
            tail.next = head2;
            tail = tail.next;
            head2 = head2.next;
        }
        tail.next = head!=null? head : head2;
        head = dummy.next;
    }
}
