class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] resultArr = new int[nums.length-k+1];
        int left = 0;
        int leftMax = Integer.MIN_VALUE;
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int right = 0; right < nums.length; right++){
    maxHeap.offer(nums[right]);
    if(right >= k-1){
        resultArr[right-k+1] = maxHeap.peek();
        maxHeap.remove(nums[right-k+1]);
    }
}
        return resultArr;
    }
}
