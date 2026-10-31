class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val, Node next, Node prev){
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public Node(int key, int val){
            this(key,val,null,null);
        }
    }

    Map<Integer,Node> map;
    Node start;
    Node end;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.start = new Node(0,0);
        this.end = new Node(0,0);
        this.start.next = this.end;
        this.end.prev = this.start;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        //if key exists, send val. mark as MRU.
        //if not, send -1
        if(map.containsKey(key)){
            markAsMRU(key);
            return map.get(key).val;
        }
        return -1;
    }

    //["LRUCache", [2], "put", [1, 10],  "get", [1], "put", [2, 20], "put", [3, 30], "get", [2], "get", [1]]
    
    public void put(int key, int value) { //1,10
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            markAsMRU(key);
        }
        else{
            if(this.map.size() >= capacity){
                removeLRU();
            }
            createAndAddToStart(key,value);
        }
    }

    private void markAsMRU(int key){
        Node node = map.get(key);
        Node next = node.next;
        Node prev = node.prev;

        next.prev = prev;
        prev.next = next;
        
        addToStart(node);
    }

    private void addToStart(Node node){
        Node existingHead = this.start.next;
        this.start.next = node;
        node.next = existingHead;
        node.prev = this.start;
        existingHead.prev = node;
    }

    private void createAndAddToStart(int key, int value){
        Node node = new Node(key,value);
        addToStart(node);
        map.put(key,node);
    }

    private void removeLRU(){
        Node node = this.end.prev;
        Node prev = node.prev;

        prev.next = this.end;
        this.end.prev = prev;

        node.prev = null;
        node.next = null;

        map.remove(node.key);
    }
}
