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
    public ListNode reverseKGroup(ListNode head, int k) {//head= 0 - [1,2,3,4,5]
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy; //0
        while(true){
            ListNode kth = getKth(groupPrev,k); //3
            if(kth == null){
                break;
            }
            ListNode groupNext = kth.next; //4

            ListNode current = groupPrev.next;
            ListNode prev = kth.next;
            while(current!=groupNext){
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = prev;
            groupPrev = temp;
        }
        return dummy.next;
    }
    private ListNode getKth(ListNode head, int k){ //0,1,2,3,4,5 k = 3
        ListNode current = head;
        while(current!=null && k>0){ // 0 , 3 | 1, 2 | 2,1 | 3,0
            current = current.next; //1 //2
            k--; //2 //1
        }
        return current;
    }
}
