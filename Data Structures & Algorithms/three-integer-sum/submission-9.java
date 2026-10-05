class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                // while(left < nums.length-1 && left < right && nums[left] == nums[left+1]) left++;
                // while(right > 1 && left < right && nums[right] == nums[right-1]) right--;
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> list = List.of(nums[i],nums[left],nums[right]);
                    result.add(list);
                    left++;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}
