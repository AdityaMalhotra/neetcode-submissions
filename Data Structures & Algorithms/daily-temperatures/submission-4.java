class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for(int i=0 ;i<temperatures.length;i++){
            if(stack.isEmpty() || stack.peek()[0]>=temperatures[i]){
                stack.push(new int[] {temperatures[i],i});
            }else{
                while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                    int[] popped = stack.pop();
                    result[popped[1]] = i-popped[1];
                }
                stack.push(new int[] {temperatures[i],i});
            }
        }
        return result;
        
    }
}
