class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        if(nums.length == 0){
            return 0;
        }
        int count = 0;
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            if(hashSet.contains(nums[i]-1)){
                count++;
            }
            if(hashSet.contains(nums[i] + 1)){
                count++;
            }
            if(!hashSet.contains(nums[i]-1) && !hashSet.contains(nums[i]+1)){
                result = Math.max(result,count);
                count = 0;
            }
            hashSet.add(nums[i]);
        }
        result = Math.max(result,count);
        return result;
    }
}
