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
        Map<Character,Integer> tempMap = new HashMap<>();
        int charsRequired = map.size();
        int currentChars = 0;
        int left = 0;
        int resultSize = Integer.MAX_VALUE;
        for(int right =0;right<s.length();right++){
            char current = s.charAt(right);
            if(map.containsKey(current)){
                int freq = tempMap.getOrDefault(current,0) + 1;
                if(freq == map.get(current)){
                    currentChars++;
                }
                tempMap.put(current,freq);
            }
            while(currentChars==charsRequired){
                char old = s.charAt(left);
                if(map.containsKey(old)){
                    int freq = tempMap.get(old)-1;
                    if(freq<map.get(old)){
                        currentChars--;
                    }
                    tempMap.put(old,freq);
                }
                if(right-left+1 < resultSize){
                    resultSize = right-left+1;
                    result = s.substring(left,right+1);
                }
                left++;
            }
        }
        return result;
    }
}
