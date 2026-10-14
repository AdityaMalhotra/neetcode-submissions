class Solution {
    public int search(int[] nums, int target) {
        
        int rotation = getRotation(nums); //3
        //arr 1 = 0..rotation.
        //arr 2 = rotation+1..last.. both sorted.
        int lastElement = nums[nums.length-1]; 
        if(target<=lastElement){
            //2nd array.
            int left = rotation+1; //4
            int right = nums.length-1; //6
            return binarySearch(nums,left,right,target);
        }else{
            //1st array.
            int left = 0;
            int right = rotation; //3
            return binarySearch(nums,left,right,target);
        }
    }

    private int getRotation(int[] nums){ //[4,5,6,7,0,1,2] - 
        int left = 0;
        int right = nums.length-1;
        
        while(left<right){
            int mid = left+(right-left)/2; //3 5 4
            if(nums[mid] < nums[nums.length-1]){
                right = mid; //5 4
            }else{
                left = mid+1; //4 
            }
        }
        int rotation = left-1; //3
        return rotation;
    }
    private int binarySearch(int[] nums,int left,int right,int target){
        while(left<=right){  //4<6
            int mid = left+(right-left)/2; //5
            if(nums[mid] == target){ //1!=0
                return mid;
            }else if(nums[mid]<target){  
                left = mid+1;
            }else{ // 1 > 0
                right = mid-1;
            }
        }
        return -1;
    }
    
}
