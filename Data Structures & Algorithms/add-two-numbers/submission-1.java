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
 // 9
 // 9
 // 18 -> 8 1
 //5 + 5 = 10.
 // 9+9 = 18 %10 = 8 .
 //18/10 = 1

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int carryOver = 0;
        while(l1!=null || l2!=null){
            int num1 = l1!=null?l1.val : 0;
            int num2 = l2!=null?l2.val : 0;
            int sum = num1+num2;
            int totalSum = sum+carryOver;
            if(totalSum>9){
                carryOver = totalSum/10;
                int digit = totalSum%10;
                tail.next = new ListNode(digit);
            }else{
                carryOver = 0;
                tail.next = new ListNode(totalSum);
            }
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(carryOver>0){
            tail.next = new ListNode(carryOver);
        }
        return dummy.next;
    }
}
