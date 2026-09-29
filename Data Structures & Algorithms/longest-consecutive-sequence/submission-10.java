class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int maxCount = 0;
        for(int num : nums){
            hashSet.add(num);
        }
        for(Integer num : hashSet){
            int count = 0;
            if(!hashSet.contains(num-1)){
                while(hashSet.contains(num + count)){
                    count++;
                }
                maxCount = Math.max(count,maxCount);

            }
        }
        return maxCount;
    }
}
