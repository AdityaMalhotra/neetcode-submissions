class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0) + 1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> freqMap.get(a) - freqMap.get(b));
        for(Integer key : freqMap.keySet()){
            minHeap.offer(key);
            if(minHeap.size() > k){
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
