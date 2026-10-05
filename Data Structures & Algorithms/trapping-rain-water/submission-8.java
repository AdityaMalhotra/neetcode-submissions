class Solution {
    public int trap(int[] height) {
        int left =0 ;
        int right = height.length-1;
        int maxL = 0;
        int maxR = 0;
        int totalAmount = 0;

        while(left<right){
            if(maxL<=maxR){
                left++;
                maxL = Math.max(maxL,height[left]);
                totalAmount+=maxL-height[left];
            }else{
                right--;
                maxR = Math.max(maxR,height[right]);
                totalAmount+=maxR-height[right];
            }
        }
        return totalAmount;
    }
}
