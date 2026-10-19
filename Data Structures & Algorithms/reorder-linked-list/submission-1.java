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
//0,1,2,3,4,5
// 2 4 6 8 - 2,4 : 6,8
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode toBeReversed = slow.next;
        slow.next = null; //make the first list point to null.

        ListNode current = toBeReversed;
        ListNode prev = null;

        while(current!=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode current1 = head;
        // System.out.println(prev.val);
        ListNode current2 = prev; //prev = head of new list after reversing.

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        int i = 0;

        while(current1!=null && current2!=null){
            if(i%2==0){
                tail.next = current1;
                current1 = current1.next;
            }else{
                tail.next = current2;
                current2 = current2.next;
            }
            tail = tail.next;
            i++;     
        }
        tail.next = (current1!=null) ? current1 : current2;

        head = dummy.next;
    }
}
