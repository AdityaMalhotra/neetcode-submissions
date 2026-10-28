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
            if(kth==null){
                break;
            }
            ListNode groupNext = kth.next;

            ListNode current = groupPrev.next;
            ListNode prev = kth.next;

            while(current!=groupNext){
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            ListNode groupEnd = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = groupEnd;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode beforeHead,int k){
        int count = 0;
        ListNode kth = beforeHead;
        while(kth!=null && count < k){
            kth = kth.next;
            count++;
        }
        return kth;
    }
}
