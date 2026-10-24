class Solution {
    public int search(int[] nums, int target) {
        int rotation = getRotation(nums);
        int result = -1;
        if(target<=nums[nums.length-1]){
            result = binarySearch(nums,rotation,nums.length-1,target);
        }else{
            result = binarySearch(nums,0,rotation-1,target);
        }
        return result;
    }

    private int binarySearch(int[] nums, int left, int right, int target){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    private int getRotation(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid] <= nums[nums.length-1]){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;
    }
}
