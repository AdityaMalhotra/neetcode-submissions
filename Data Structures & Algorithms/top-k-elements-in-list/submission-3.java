class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int num : nums){
            hashMap.put(num,hashMap.getOrDefault(num,0) + 1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> { return hashMap.get(a) - hashMap.get(b);});
        for(int num : hashMap.keySet()){
            minHeap.offer(num);
            if(minHeap.size()> k){
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
