class Solution {
    public int trap(int[] height) {
        int left =0 ;
        int right = height.length-1;
        int maxL = 0;
        int maxR = 0;
        int totalAmount = 0;

        while(left<right){
            maxL = Math.max(maxL,height[left]);
            maxR = Math.max(maxR,height[right]);
            int min = Math.min(maxL,maxR);
            if( min > height[left]){
                totalAmount+= min-height[left];
            }
            if(maxL<=maxR){
                left++;
            }else{
                right--;
            }
        }
        return totalAmount;
    }
}
