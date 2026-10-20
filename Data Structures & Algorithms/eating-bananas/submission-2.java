class Solution {
    public int minEatingSpeed(int[] piles, int h) {//piles=[25,10,23,4], h =4
        int left = 1; //1
        int result = 1;
        int max = 0;
        for(int pile : piles){
            max = Math.max(pile,max);
        }
        int right = max; //25
        while(left<=right){
            int mid = left+(right-left)/2; //14+(25-14)/2 = 19
            int timeTaken = 0;
            for(int i=0;i<piles.length;i++){
                timeTaken+= Math.ceil((double)piles[i]/mid); //2+1+2+1 = 6
            }
            if(timeTaken<=h){  //
                result = mid; //
                right = mid-1; //
            }else{ //6>4
                left = mid+1; //14
            }
        }
        return result;
    }
}
