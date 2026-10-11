class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int max = -1;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        int right = max;
        while(left<right){
            int mid = left + (right-left)/2;
            int timeTaken = piles.length;
            int hoursNeeded = 0;
            for(int i = 0;i<piles.length;i++){
                hoursNeeded+=Math.ceil((double)piles[i]/mid);
            }
            if(hoursNeeded > h){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
