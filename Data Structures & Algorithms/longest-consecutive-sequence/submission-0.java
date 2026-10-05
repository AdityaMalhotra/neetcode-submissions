class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> hashSet = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }
        int counter = 0;
        Integer previous = null;
        for(Integer current : hashSet) {
            if(previous!=null){
                if(current-previous == 1){  
                    counter++;
                }
                else {
                    result = Math.max(result,counter);
                    counter = 0;
                }
            }
            previous = current;
        }
        result = Math.max(result,counter);
        return result+1;
        // nums=[0,3,2,5,4,6,1,1]
    }
}
