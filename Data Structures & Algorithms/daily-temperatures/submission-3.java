class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i=0;i<temperatures.length;i++){
            while(stack.peek()!=null && stack.peek()[0] < temperatures[i]){
                int[] popped = stack.pop();
                result[popped[1]] = i - popped[1];
            }
            stack.push(new int[] {temperatures[i],i});
        }
        return result;
    }
}
