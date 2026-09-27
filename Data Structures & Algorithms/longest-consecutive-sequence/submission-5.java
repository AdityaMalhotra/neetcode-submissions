class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        if(nums.length <= 1){
            return nums.length;
        }
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(!hashSet.contains(nums[i]-1)){
                int count = 1;
                while(hashSet.contains(nums[i]+count)){
                    count++;
                }
                result = Math.max(count,result);
            }
        }
        return result;
    }
}
