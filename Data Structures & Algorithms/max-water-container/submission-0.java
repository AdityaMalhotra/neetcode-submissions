class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right  = heights.length-1;
        while(left<right){
            // [1,7,2,5,4,7,3,6]
            int area = (right-left) * Math.min(heights[left],heights[right]);
            max = Math.max(max,area);
            if(heights[left]<heights[right]){
                left++;
            }else {right--;}
        }
        return max;
    }
}
