class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount = 0;
        Set<Integer> hashSet = new HashSet<>();
        for(int num : nums){
            hashSet.add(num);
        }
        for(int num : hashSet){
            if(!hashSet.contains(num-1)){
                int count = 0;
                while(hashSet.contains(num+count)){
                    count++;
                }
                maxCount=Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
}
