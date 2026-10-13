class MinStack {
    List<Integer> list;
    List<Integer> minList;

    public MinStack() {
        list = new ArrayList<>();
        minList = new ArrayList<>();
    }
    
    public void push(int val) {
        list.addLast(val);
        if(minList.isEmpty()){
            minList.addLast(val);
        }else{
            minList.addLast(Math.min(minList.getLast(),val));
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
        return minList.getLast();
    }
}
