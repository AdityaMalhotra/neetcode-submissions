class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0;i<heights.length;i++){
            if(stack.isEmpty() || stack.peek()[1] <= heights[i]){
                stack.push(new int[] {i, heights[i]});
            }else{
                int currentArea = 0;
                int prevIndex = -1;
                while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                    int[] popped = stack.pop();
                    prevIndex = popped[0];
                    currentArea = popped[1]*(i-prevIndex);
                    maxArea = Math.max(currentArea,maxArea);
                }
                stack.push(new int[] {prevIndex,heights[i]});
            }
        }
        while(!stack.isEmpty()){
            int[] popped = stack.pop();
            int prevIndex = popped[0];
            int currentArea = popped[1]*(heights.length-prevIndex);
            maxArea = Math.max(currentArea,maxArea);
        }
        return maxArea;
    }
}
