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
    public ListNode mergeKLists(ListNode[] lists) { //lists=[[1,2,4],[1,3,5],[3,6]]
        Queue<ListNode> minHeap = new PriorityQueue<ListNode>((a,b) -> Integer.compare(a.val,b.val));
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                minHeap.offer(lists[i]); //1,1,3
            }
        }

        ListNode dummy = new ListNode(0); //0
        ListNode tail = dummy; //0->
        while(!minHeap.isEmpty()){
            ListNode polled = minHeap.poll(); //1
            if(polled.next!=null){
                minHeap.offer(polled.next); //2/3
            }
            tail.next = polled; //1
            tail = tail.next;
        }
        return dummy.next;
    }
}
