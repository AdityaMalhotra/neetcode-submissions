class Solution {
    public int search(int[] nums, int target) {
        int rotation = getRotationIndex(nums);
        if(target <= nums[nums.length-1]){
            return binarySearch(nums,rotation+1,nums.length-1,target);
        }else{
            return binarySearch(nums,0,rotation,target);
        }
    }
    //[4,5,6,7,0,1,2]
    private int getRotationIndex(int[] nums){
        int left = 0; //0 4 4
        int right = nums.length-1; //6 6 5
        while(left<right){
            int mid = left+(right-left)/2; //3 5 4
            if(nums[mid] <= nums[nums.length-1]){  //1<=2 0<=2
                right=mid; // 5 4
            }else{ //7 > 2
                left = mid+1; //4
            }
        }
        return left-1;
    }
    private int binarySearch(int[] nums,int left, int right,int target){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}
