class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Store everything in Hashmap
        // Put everything in HM into minHeap. if elemnt > k, discard the top.
        // display in reverse order
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i :nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(Integer key : map.keySet()){
            minHeap.offer(key);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        int[] result = new int[minHeap.size()];
        for(int i = minHeap.size()-1;i>-1;i--){
            result[i] = minHeap.remove();
        }
        return result;
    }
}
