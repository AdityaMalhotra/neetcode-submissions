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
        Map<Node,Node> map = new HashMap<>();
        Node current = head;
        while(current!=null){
            map.put(current,new Node(current.val));
            current = current.next;
        }

        for(Node key : map.keySet()){
            Node next = key.next;
            Node random = key.random;

            Node copiedNode = map.get(key);
            copiedNode.next = map.get(next);
            copiedNode.random = map.get(random);
        }

        return map.get(head);
    }
}
