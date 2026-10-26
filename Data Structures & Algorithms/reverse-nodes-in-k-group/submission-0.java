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
        ListNode dummy = new ListNode(0,head);
        ListNode groupPrev = dummy;
        while(true){
            ListNode kth = getKth(groupPrev,k);
            if(kth == null){
                break;
            }
            ListNode groupNext = kth.next;
            //Reverse
            ListNode prev = kth.next;
            ListNode current = groupPrev.next;
            while(current!=groupNext){
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode head, int k){
        ListNode current = head;
        int count = 0;
        while(count<k && current!=null){
            count++;
            current=current.next;
        }
        return current;
    }
}
