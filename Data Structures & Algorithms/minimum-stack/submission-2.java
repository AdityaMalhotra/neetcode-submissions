class MinStack {
    List<Integer> list;
    int top;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        top = 0;
        list = new ArrayList<>();
        list.add(top, null);
    }
    
    public void push(int val) {
        list.add(++top, val);//0
        min = Math.min(val,min);
    }
    
    public void pop() {
        int removed = list.remove(top);
        top--;
        if(removed == min){
            min = top();
            for(Integer i : list){
                if(i!=null){
                    min = Math.min(i,min);
                }
            }
        }
    }
    
    public int top() {
        return list.get(top);
    }
    
    public int getMin() {
        return min;
    }
}
