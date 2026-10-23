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
        Queue<ListNode> priorityQueue = new PriorityQueue<>((a,b) -> {return a.val - b.val;});
        for(int i = 0;i<lists.length;i++){
            ListNode current = lists[i];
            while(current!=null){
                priorityQueue.offer(current);
                current=current.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!priorityQueue.isEmpty()){
            tail.next = priorityQueue.poll();
            tail = tail.next;
        }
        return dummy.next;
    }
}
