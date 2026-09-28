class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> visited = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[left]);
                    subList.add(nums[right]);
                    if(!visited.contains(subList)){
                        list.add(subList);
                        visited.add(subList);
                    }
                    left++;
                    right--;
                }
                else if(sum > 0){
                    right--;
                }else left++;
            }
        }
        return list;
    }
}
