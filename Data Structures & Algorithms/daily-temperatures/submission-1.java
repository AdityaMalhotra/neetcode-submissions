class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i< temperatures.length;i++){
            if(stack.isEmpty()){
                stack.push(new int [] {temperatures[i],i});
            }
            else{
                int[] existing = stack.peek();
                if(temperatures[i] > existing[0]){
                    while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                        int[] popped = stack.pop();
                        result[popped[1]] = i - popped[1];
                    }
                }
                stack.push(new int[] {temperatures[i],i});
            }
        }
        return result;
    }
}
