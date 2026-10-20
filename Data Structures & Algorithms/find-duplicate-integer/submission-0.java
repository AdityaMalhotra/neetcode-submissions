class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int num : nums){
            if(hashSet.contains(num)){
                return num;
            }
            hashSet.add(num);
        }
        return -1;
    }
}
