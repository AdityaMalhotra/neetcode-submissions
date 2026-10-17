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
        // [0,1,2,3,4,5,6]
        // [0,6,1,5,2,4,3]
        //left = head, right = lastNode
        // left goes from left, right from right. But how do we keep track of elements from right to left? 
        // 1. We can do this easily by copying elements to array. But that requires O(n) space.
        // 2. Another way is to go back and forth for each node. That takes O(n2) time.
        // 3. Another way is to store links/references to all nodes. But that takes O(n) space.
        // We definitely have to calculate the length so we have to go all the way to the end.
        //Recursion? - But the question asks to keep space complexity 1, that uses O(n) bcz stack
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow = mid;

        ListNode current1 = head;
        
        ListNode second = slow.next;
        slow.next = null;
 
        ListNode previous = null;

        while(second!=null){
            ListNode temp = second.next;
            second.next = previous;
            previous = second;
            second = temp;
        } // List reversed. with previous. as first element.

        ListNode current2 = previous;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int i = 0;
        while(current1!=null && current2!=null){
            if(i%2 == 0){
                tail.next = current1;
                current1 = current1.next;
            }else{
                tail.next = current2;
                current2 = current2.next;
            }
            tail=tail.next;
            i++;
        }
        tail.next = (current1!=null)? current1 : current2;
        head = dummy.next;
    }
}
