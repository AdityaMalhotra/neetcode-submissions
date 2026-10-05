class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxCount = 0;
        for(int num : nums){
            set.add(num);
        }
        for(Integer setKey : set){
            if(!set.contains(setKey-1)){
                int count = 0;
                while(set.contains(setKey + count)){
                    count++;
                }
                maxCount = Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
}
