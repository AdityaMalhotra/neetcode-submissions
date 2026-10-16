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
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        if(current == null || current.next==null){
            return current;
        }
        ListNode previous = null;
        //[0,1]
        while(current!=null){ //1
            ListNode temp = current.next;
            current.next=previous; //0
            previous = current; //1
            current = temp; //null
        }
        return previous;
    }
}
