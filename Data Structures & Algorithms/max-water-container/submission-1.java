class Solution {
    public int maxArea(int[] heights) {
        //min(height[i]) * right-left
        int maxArea = 0;
        int left = 0;
        int right = heights.length-1;
        while(left<right){
            maxArea = Math.max(maxArea, Math.min(heights[left],heights[right]) * (right-left));
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
