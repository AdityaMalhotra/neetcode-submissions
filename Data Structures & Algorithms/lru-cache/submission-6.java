class LRUCache {

    Node start;
    Node end;

    Map<Integer, Node> map;
    int capacity;

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        public Node(int key, int val, Node next, Node prev){
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }


    public LRUCache(int capacity) {
        start = new Node(0,0);
        end = new Node(0,0);

        start.next = end;
        end.prev = start;
        map = new HashMap<>();

        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            markAsMRU(key);
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            map.put(key,node);
            markAsMRU(key);
        }else{
            if(map.size() >= this.capacity){
                removeLRU();
            }
            Node node = new Node(key,value);
            attachAsHead(node);
            map.put(key,node);
        }
    }

    private void markAsMRU(int key){
        Node node = map.get(key);
        Node next = node.next;
        Node prev = node.prev;

        next.prev = prev;
        prev.next = next; //breaks link

        attachAsHead(node);
    }

    private void attachAsHead(Node node){
        Node head = this.start.next;
        this.start.next = node; //New head
        node.next = head; //Prev head is attached to node's next.
        node.prev = this.start;
        head.prev = node;
    }

    private void removeLRU(){
        Node toBeRemoved = this.end.prev;
        Node prev = toBeRemoved.prev;
        prev.next = this.end;
        this.end.prev = prev;

        toBeRemoved.next = null;
        toBeRemoved.prev = null;
        map.remove(toBeRemoved.key);
    }
}
