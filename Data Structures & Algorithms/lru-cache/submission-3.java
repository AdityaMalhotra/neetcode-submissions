class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val,Node next,Node prev){
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        Node(){}
    }

    private int capacity;

    Map<Integer,Node> map;
    Node start;
    Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.start = new Node(-1,-1);
        this.end = new Node(-1,-1);
        this.start.next = end;
        this.end.prev = start;
    }
    
    public int get(int key) {
        //Get from cache in O(1).
        // If not in cache return -1;
        int result = -1;

        if(map.containsKey(key)){
            Node node = map.get(key);
            shiftToFront(key);
            return node.val;
        }
        return result;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node existingNode = map.get(key);
            if(existingNode.val != value){
                existingNode.val = value;
                map.put(key,existingNode);
            }
            shiftToFront(key);
        }else{
            if(map.size() >= capacity){
                removeLRU();
            }
            addToCache(key,value);
        }
    }

    private void shiftToFront(int key){
        Node node = map.get(key);
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;

        Node startNext = this.start.next;
        startNext.prev = node;
        node.next = startNext;
        node.prev = start;
        this.start.next = node;
    }

    private void removeLRU(){
        Node lru = this.end.prev;
        Node prev = lru.prev;
        prev.next = this.end;
        this.end.prev = prev;
        map.remove(lru.key);
    }
    private void addToCache(int key,int val){
        Node node = new Node(key,val);
        Node next = this.start.next;
        next.prev = node;
        node.next = next;
        node.prev = start;
        this.start.next = node;
        map.put(key,node);
    }
}
