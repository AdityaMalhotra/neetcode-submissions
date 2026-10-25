class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0;i<heights.length;i++){
            if(stack.isEmpty() || stack.peek()[1] < heights[i]){
                stack.push(new int[] {i,heights[i]});
            }else{
                int area = 0;
                int prevIndex = stack.peek()[0];
                while(!stack.isEmpty() && stack.peek()[1]>= heights[i]){
                    int[] popped = stack.pop();
                    area = popped[1] * (i-popped[0]);
                    maxArea = Math.max(maxArea,area);
                    prevIndex = popped[0];
                }
                stack.push(new int[] {prevIndex, heights[i]});
            }
        }

        while(!stack.isEmpty()){
            int[] popped = stack.pop();
            int area = popped[1] * (heights.length-popped[0]);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
