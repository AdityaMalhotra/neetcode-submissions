class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        for(int i = 0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        int left = 0;
        int right = max;
        while(left<right){
            int mid = left+(right-left)/2;
            int hoursRequired = 0;
            for(int i=0;i<piles.length;i++){
                hoursRequired+=Math.ceil((double)piles[i]/mid);
            }
            if(hoursRequired>h){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
