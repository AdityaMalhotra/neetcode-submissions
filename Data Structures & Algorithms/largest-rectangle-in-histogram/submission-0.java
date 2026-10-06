class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty() || stack.peek()[1] <= heights[i]){
                stack.push(new int[] {i,heights[i]});
            }else{
                int lastIndex = stack.peek()[0];
                while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                    int[] popped = stack.pop();
                    maxArea = Math.max(maxArea, (i - popped[0]) * popped[1]);
                    lastIndex = popped[0];
                }
                stack.push(new int[] {lastIndex,heights[i]});
            }
        }
        while(!stack.isEmpty()){
            int[] popped = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - popped[0]) * popped[1]);
        }
        return maxArea;
    }
}
