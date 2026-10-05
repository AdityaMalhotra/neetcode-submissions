class Solution {
    public int trap(int[] height) {
        //water[i] = Min(max height before i, max height after i) - height[i]
        int total = 0;
        int left = 0;
        int leftMax = height[0];
        int right = height.length-1;
        int rightMax = height[right];
        while(left<right){
            if(leftMax<=rightMax){
                left++;
                if(leftMax> height[left]){
                    total+=leftMax - height[left];
                }
                leftMax = Math.max(height[left],leftMax);
            }else{
                right--;
                if(rightMax > height[right]){
                    total+=rightMax - height[right];
                }
                rightMax = Math.max(height[right],rightMax);
            }
        }
        return total;
    }
}
