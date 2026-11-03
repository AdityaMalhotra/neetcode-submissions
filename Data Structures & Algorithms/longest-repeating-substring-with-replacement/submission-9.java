class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int maxFreq = 0;
        int result = 0;
        // s="AAABABB"
        //    0123456
        // k=1
        for(int right = 0;right<s.length();right++){

            int freq = map.containsKey(s.charAt(right))? map.get(s.charAt(right)) + 1 : 1;
            map.put(s.charAt(right),freq);
            maxFreq = Math.max(maxFreq,freq); //A = 4, B=1 

            while(right-left+1 - maxFreq > k){
                int oldFreq = map.get(s.charAt(left));
                map.put(s.charAt(left),oldFreq-1);
                left++;
            }

            result = Math.max(result,right-left+1); //5

        }

        return result;
    }
}
