class Solution {
    public int trap(int[] height) {
        int[] waterLevel = new int[height.length];
        for(int i=0;i<height.length;i++){
            int leftMax = getMaxHeight(height,0,i);
            int rightMax = getMaxHeight(height,i+1,height.length);
            if(leftMax>height[i] && rightMax > height[i]){
                int min = Math.min(leftMax,rightMax);
                waterLevel[i] = min - height[i];
            }
        }
        int totalArea = 0;
        for(int i=0;i<waterLevel.length;i++){
            System.out.print("Water level: " + i + " : " + waterLevel[i]);
            totalArea+=waterLevel[i];
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
