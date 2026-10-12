class Solution {
    public int findMin(int[] nums) {
        // [3,4,5,6,1,2]
        // Condition/invariant = mid < last element.
        // Applying conditon - we get [F,F,F,F,T,T]
        // [1,2,3,4,5,6] 5-0/2 = 2 3<
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+ (right-left)/2;
            if(nums[mid] < nums[nums.length-1]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return nums[left];
    }
}
