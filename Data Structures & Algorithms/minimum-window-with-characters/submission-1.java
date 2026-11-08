class Solution {
    public String minWindow(String s, String t) {
        //s="xyz"
        // t="xyz"
        if(t.length() > s.length()){
            return "";
        }
        Map<Character,Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0) + 1);
        }
        int requiredChars = tMap.size();
        int currentChars = 0;
        int left = 0;
        
        String result ="";
        int resultLength = Integer.MAX_VALUE;

        Map<Character,Integer> sMap = new HashMap<>();
        for(int right = 0;right<s.length();right++){
            char currentChar = s.charAt(right);
            if(tMap.containsKey(currentChar)){
                sMap.put(currentChar,sMap.getOrDefault(currentChar,0) + 1);
                int freq = sMap.get(currentChar);
                if(freq == tMap.get(currentChar)){
                    currentChars++;
                }
            }
            while(currentChars==requiredChars){
                char oldChar = s.charAt(left);
                if(tMap.containsKey(oldChar)){
                    sMap.put(oldChar,sMap.get(oldChar) -1);
                    int freq = sMap.get(oldChar);
                    if(freq < tMap.get(oldChar)){
                        currentChars--;
                    }
                }
                if(right-left+1 < resultLength){
                    resultLength = right-left+1;
                    result = s.substring(left,right+1);
                }
                left++;
            }
        }
        return result;
    }
}
