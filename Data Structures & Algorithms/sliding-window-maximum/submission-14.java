class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        int left = 0;
        for(int right = 0;right<nums.length;right++){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[right]){
                queue.pollLast();
            }
            queue.offerLast(right);

            if(left > queue.peekFirst()){
                queue.pollFirst();
            }

            if(right-left+1 >= k){
                result[left] = nums[queue.peekFirst()];
                left++;
            }
        }
        return result;
    }
}
