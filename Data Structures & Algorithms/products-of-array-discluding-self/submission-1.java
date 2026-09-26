class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftArr = new int[nums.length];
        int[] rightArr = new int[nums.length];

        int leftProd = 1;
        int rightProd = 1;
        for(int i = 0;i<nums.length;i++){
            if(i>0){
                leftProd*=nums[i-1];
            }
            leftArr[i] = leftProd;
        }
        for(int i = nums.length-1;i>-1;i--){
            if(i<nums.length-1){
                rightProd*=nums[i+1];
            }
            rightArr[i] = rightProd;
        }

        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            result[i] = leftArr[i]*rightArr[i];
        }
        return result;
    }
}  
