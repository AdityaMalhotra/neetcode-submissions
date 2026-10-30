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

        for(Node k : map.keySet()){
            Node newNode = map.get(k);
            newNode.next = map.get(k.next);
            newNode.random = map.get(k.random);
        }

        return map.get(head);
    }
}
