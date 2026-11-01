class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> hashMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        int maxCount = 0;
        while(right < s.length()){ //right=4 (B): map {A:3,B:2}, maxCount=3. Window AABAB, length 5, 5-3=2 > 1, invalid. Shrink: remove A at left=0 → {A:2,B:2}, recompute maxCount=2, left→1.
            Character currentChar = s.charAt(right); //A
            hashMap.put(currentChar,hashMap.getOrDefault(currentChar,0)+1);//1
            maxCount = Math.max(maxCount,hashMap.get(currentChar));//1
            
            if(right - left + 1 - maxCount <= k){ //4 - 1 + 1 <=2 false
                result = Math.max(result,right-left+1);//1
            }else{ 
                while(right - left + 1 - maxCount > k){
                    Character leftChar = s.charAt(left); //A - removed
                    hashMap.put(leftChar,hashMap.get(leftChar)-1); //A:2, B:2
                    left++; //1
                }
                maxCount=0;
                for(Character ch : hashMap.keySet()){
                    maxCount = Math.max(maxCount,hashMap.get(ch)); //2
                }
            }
            right++;//1
        }
        return result;
    }
}
