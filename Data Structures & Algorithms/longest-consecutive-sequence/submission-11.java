class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }
        int count = 0;
        int index = 0;
        while(index<nums.length){
            if(!hashSet.contains(nums[index]-1)){
                int currentCount = 0;
                int next = nums[index];
                while(index < nums.length && hashSet.contains(next)) {
                    currentCount++;
                    next = next+1;
                }
                count = Math.max(count,currentCount);
            }
            index++;
        }
        return count;
    }
}
