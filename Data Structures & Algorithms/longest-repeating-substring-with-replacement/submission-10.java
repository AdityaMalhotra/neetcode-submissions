class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int maxFreq = 0;
        int result = 0;
        for(int right = 0;right<s.length();right++){
            char current = s.charAt(right);
            int freq = map.containsKey(current) ? map.get(current) + 1: 1;
            map.put(current,freq);
            maxFreq = Math.max(freq,maxFreq);

            if(right - left +1 - maxFreq > k){
                while(right - left +1 - maxFreq > k){
                    char old = s.charAt(left);
                    int oldFreq = map.get(old) -1;
                    map.put(old,oldFreq);
                    left++;
                }
            }
            result = Math.max(result,right-left+1);
        }
        return result;
    }
}
