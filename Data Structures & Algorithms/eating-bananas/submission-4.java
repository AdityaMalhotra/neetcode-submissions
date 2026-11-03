class Solution {
    public int minEatingSpeed(int[] piles, int h) { //piles=[1,4,3,2], h =9
        int left = 1;
        int max = 0;
        
        for(int pile : piles){
            max = Math.max(max,pile);
        }
        int right = max;

        while(left<right){
            int mid = left + (right-left)/2; //0 - 4 2+(4-2)/2 = 3
            int totalTime = 0;
            for(int i = 0;i<piles.length;i++){
                totalTime+=Math.ceil(((double)piles[i])/mid); // 1 + 2 + 2 + 1 = 6 <= 9
            }
            if(totalTime <= h){
                right = mid; //2
            }else{
                left = mid+1;
            }
        }

        return left;
    }
}
