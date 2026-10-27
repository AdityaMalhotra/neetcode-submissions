class Solution {
    public int minEatingSpeed(int[] piles, int h) { //1,4,3,2
        int left = 1;
        int max = 0;
        for(int pile : piles){
            max = Math.max(max,pile); //4
        }
        int right = max;

        while(left<right){
            int mid = left + (right-left)/2; //2
            int total = 0;
            for(int i=0;i<piles.length;i++){
                total+=Math.ceil(((double)piles[i])/mid); // 1 2 2 1 = 6
            }
            if(total <= h){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
