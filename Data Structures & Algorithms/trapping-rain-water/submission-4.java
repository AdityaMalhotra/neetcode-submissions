class Solution {
    public int trap(int[] height) {
        int totalArea = 0;
        int leftMax = 0;
        int[] rightMaxHeights = new int[height.length];
        int rightMaxHeight = 0;
        for(int i=rightMaxHeights.length-1;i>-1;i--){
            rightMaxHeights[i] = rightMaxHeight;
            if(height[i] > rightMaxHeight){
                rightMaxHeight = height[i];
            }
        }
        for(int i=0;i<height.length;i++){
            if(i > 0 && leftMax<height[i-1]) leftMax = height[i-1];
            int rightMax = rightMaxHeights[i];
            if(leftMax>height[i] && rightMax > height[i]){
                int min = Math.min(leftMax,rightMax);
                totalArea+= min - height[i];
            }
        }
        return totalArea;
    }
    private int getMaxHeight(int[] input, int left,int right){
        int maxHeight = 0;
        for(int i=left;i<right;i++){
            maxHeight = Math.max(maxHeight,input[i]);
        }
        return maxHeight;
    }

    //water(i) = Min(MaxHeight((0..i-1)),MaxHeight(i+1..n)) - height(i)
}
