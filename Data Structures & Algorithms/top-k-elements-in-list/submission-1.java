class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        for(Integer key : map.keySet()){
            minHeap.offer(key);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] result = new int[minHeap.size()];
        for(int i=minHeap.size()-1;i>-1;i--){
            result[i] = minHeap.poll();
        }
        return result;
    }
}
