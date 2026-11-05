class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if(t.equals("") || t.length() > s.length()){
            return result;
        }
        int resultLength = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        int charsToMatch = map.size();

        Map<Character,Integer> windowMap = new HashMap<>();
        int charsMatched = 0;
        int left = 0;
        for(int right = 0;right<s.length();right++){
            char current = s.charAt(right);
            if(map.containsKey(current)){
                int freq = windowMap.containsKey(current) ? windowMap.get(current)+1 : 1;
                windowMap.put(current,freq);
                if(freq == map.get(current)){
                    charsMatched++;
                }
            }
            while(charsMatched == charsToMatch){
                char old = s.charAt(left);
                if(map.containsKey(old)){
                    int freq = windowMap.containsKey(old) ? windowMap.get(old)-1 : 0;
                    windowMap.put(old,freq);
                    if(freq < map.get(old)){
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
