class MinStack {
    List<Integer> list;
    int top;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        top = -1;
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(++top, val);//0
        min = Math.min(val,min);
    }
    
    public void pop() {
        int removed = list.remove(top--);
        if(removed == min){
            min = top();
            for(int i : list){
                min = Math.min(i,min);
            }
        }
    }
    
    public Integer top() {
        if(top == -1){
            return null;
        }
        return list.get(top);
    }
    
    public int getMin() {
        return min;
    }
}
