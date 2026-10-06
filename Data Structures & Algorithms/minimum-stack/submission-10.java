class MinStack {

    List<Integer> list;
    List<Integer> minList;

    public MinStack() {
        list = new LinkedList<>();
        minList = new LinkedList<>();
    }
    
    public void push(int val) {
        list.addLast(val);
        if(minList.size() > 0){
            minList.addLast(Math.min(val,minList.getLast()));
        } else{
            minList.addLast(val);
        }
    }
    
    public void pop() {
        list.removeLast();
        minList.removeLast();
    }
    
    public int top() {
        return list.getLast();
    }
    
    public int getMin() {
        return minList.get(minList.size()-1);
    }
}
