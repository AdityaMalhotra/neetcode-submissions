class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int[] result = new int[nums.length];
        for(int num : nums){
            totalProduct*=num;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                result[i] = totalProduct/nums[i];
            }else{
                result[i] = getProductExceptZero(nums,i);
            }
        }
        return result;
    }
    private int getProductExceptZero(int[] nums, int index){
        int totalProduct = 1;
        for(int i = 0;i<nums.length;i++){
            if(i!=index){
                totalProduct*=nums[i];
            }
        }
        return totalProduct;
    }
}  
