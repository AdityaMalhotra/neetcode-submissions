class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0;
        int[] result = new int[nums.length - k + 1];
        for(int right = 0;right<nums.length;right++){
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]){
                deque.pollLast();
            }
            deque.offerLast(right);

            if(left > deque.peekFirst()){
                deque.pollFirst();
            }

            if(right - left >= k-1){
                result[left] = nums[deque.peekFirst()];
                left++;
            }
        }
        return result;
    }
}
