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

class Solution { //Heap approach.
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        Queue<ListNode> minHeap = new PriorityQueue<>((a,b) -> {return a.val - b.val;});
        for(ListNode list : lists){
            if(list!=null){
                minHeap.offer(list);
            }
        }
        while(!minHeap.isEmpty()){
            ListNode polled = minHeap.poll();
            if(polled.next!=null){
                minHeap.offer(polled.next);
            }
            tail.next = polled;
            tail = tail.next;
        }
        
        return dummy.next;
    }
}
