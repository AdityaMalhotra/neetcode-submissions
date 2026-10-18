class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty() || stack.peek()[1] <= heights[i]){
                stack.push(new int[] {i,heights[i]});
            }else{
                int prevIndex = stack.peek()[0];
                while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                    int[] popped = stack.pop();
                    int currentArea = (i-popped[0])*popped[1];
                    maxArea = Math.max(maxArea,currentArea);
                    prevIndex = popped[0];
                }
                stack.push(new int[] {prevIndex, heights[i]});
            }
        }
        while(!stack.isEmpty()){
            int[] popped = stack.pop();
            int currentArea = (heights.length-popped[0])*popped[1];
            maxArea = Math.max(maxArea,currentArea);
        }
        return maxArea;
    }
}
