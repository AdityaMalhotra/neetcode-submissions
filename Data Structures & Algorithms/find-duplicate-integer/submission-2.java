class Solution {
    public int findDuplicate(int[] nums) {
        //nums = [1,2,3,2,2]

        int fast = nums[0]; //1
        int slow = nums[0]; //1

        while(true){
            fast = nums[nums[fast]];    //nums[nums[1] = nums[2] = 3 // nums[nums[3]] = nums[2] = 3
            slow = nums[slow];          //nums[1] = 2 nums[2] = 3
            if(fast == slow){
                break; // slow = 3
            }
        }

        fast = nums[0]; // fast = 1
        while(fast!=slow){ //1!=3
            fast = nums[fast]; //  2
            slow = nums[slow]; // 2
        }
        return slow; //2
    }
}
