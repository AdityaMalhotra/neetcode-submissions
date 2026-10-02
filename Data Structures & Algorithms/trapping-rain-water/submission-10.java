class Solution {
    public int trap(int[] height) {
        int total = 0;
        int left = 0;
        int leftMax = height[left];
        int right = height.length-1;
        int rightMax = height[right];
        while(left<right){
            if(leftMax<=rightMax){
                left++;
                leftMax=Math.max(leftMax,height[left]);
                if(leftMax>height[left]){
                    total+=leftMax-height[left];
                }
            }else{
                right--;
                rightMax=Math.max(rightMax,height[right]);
                if(rightMax > height[right]){
                    total+=rightMax-height[right];
                }
            }
        }
        return total;
    }
}
