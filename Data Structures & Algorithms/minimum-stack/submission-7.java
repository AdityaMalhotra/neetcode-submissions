class MinStack {
    List<Integer> list;
    List<Integer> minArr;
    int top;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        top = -1;
        list = new ArrayList<>();
        minArr = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(++top, val);//20
        if(top > 0){
            minArr.add(top,Math.min(minArr.get(top-1),val));
        }else{
            minArr.add(top,val);
        }
        
    }
    
    public void pop() {
        int removed = list.remove(top--);//10
    }
    
    public int top() {
        return list.get(top);
    }
    
    public int getMin() {
        return minArr.get(top);
    }
}
