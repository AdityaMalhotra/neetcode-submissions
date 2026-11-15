class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if(t.length() > s.length()){
            return result;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        int charsToMatch = map.size();

        Map<Character,Integer> tempMap = new HashMap<>();
        int charsMatched = 0;

        int left = 0;
        int resultLength = Integer.MAX_VALUE;
        //s="OUZODYXAZV"
        // t="XYZ"
        for(int right = 0;right<s.length();right++){
            char current = s.charAt(right);
            if(map.containsKey(current)){
                int freq = tempMap.containsKey(current) ? tempMap.get(current) + 1 : 1;
                tempMap.put(current,freq);
                if(freq == map.get(current)){
                    charsMatched++;
                }
            }
            while(charsMatched == charsToMatch){
                char old = s.charAt(left);
                if(map.containsKey(old)){
                    int oldFreq = tempMap.get(old) - 1;
                    tempMap.put(old,oldFreq);
                    if(oldFreq < map.get(old)){
                        charsMatched--;
                    }
                }
                if(resultLength > right-left+1){
                    resultLength = right-left+1;
                    result = s.substring(left,right+1);
                }
                left++;
            }
        }
        return result;
    }
}
