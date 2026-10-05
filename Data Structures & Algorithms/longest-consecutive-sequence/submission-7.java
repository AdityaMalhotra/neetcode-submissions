class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int maxCount = 0;
        for(int num : nums){
            hashSet.add(num);
        }
        for(int i=0;i<hashSet.size();i++){
            int count = 0;
            if(!hashSet.contains(nums[i]-1)){
                while(hashSet.contains(nums[i]+ count)){
                    count++;
                }
                maxCount = Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
}
