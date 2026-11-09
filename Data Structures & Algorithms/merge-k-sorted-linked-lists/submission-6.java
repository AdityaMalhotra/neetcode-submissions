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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list!=null){
                minHeap.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!minHeap.isEmpty()){
            ListNode polled = minHeap.poll();
            tail.next = polled;
            if(polled.next!=null){
                minHeap.offer(polled.next);
            }
            tail = tail.next;
        }

        return dummy.next;
    }
}
