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
        Queue<ListNode> minHeap = new PriorityQueue<>((a,b) -> {return Integer.compare(a.val,b.val);});
        for(ListNode list : lists){
            if(list!=null){
                minHeap.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!minHeap.isEmpty()){
            ListNode min = minHeap.poll();
            tail.next = min;
            if(min.next!=null){
                minHeap.offer(min.next);
            }
            tail = tail.next;
        }
        return dummy.next;
    }
}
