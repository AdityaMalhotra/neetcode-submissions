/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node origHead = head;
        Map<Node,Node> hashMap = new HashMap<>();
        while(head!=null){
            hashMap.put(head,new Node(head.val));
            head = head.next;
        }
        for(Node original : hashMap.keySet()){
            Node origNext = original.next;
            Node origRandom = original.random;
            Node copied = hashMap.get(original);
            if(origNext!=null){
                copied.next = hashMap.get(origNext);
            }
            if(origRandom!=null){
                copied.random =hashMap.get(origRandom);
            }
        }

        return hashMap.get(origHead);
    }
}
