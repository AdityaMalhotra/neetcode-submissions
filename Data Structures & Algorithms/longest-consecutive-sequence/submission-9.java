class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int maxCount = 0;
        for(int num : nums){
            hashSet.add(num);
        }
        int i = 0;
        while(i<hashSet.size()){
            int count = 0;
            if(!hashSet.contains(nums[i]-1)){
                while(hashSet.contains(nums[i]+ count)){
                    count++;
                }
                maxCount = Math.max(count,maxCount);
            }
            i++;
        }
        return maxCount;
    }
}
