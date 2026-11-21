class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }

        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        Map<Character,Integer> tempMap = new HashMap<>();

        int left = 0;
        
        for(int right = 0;right<s2.length();right++){
            if(right-left+1 > s1.length()){
                char oldChar = s2.charAt(left);
                int freq = tempMap.get(oldChar) - 1;
                if(freq < 1){
                    tempMap.remove(oldChar);
                }else{
                    tempMap.put(oldChar,freq);
                }
                left++;
            }
            char newChar = s2.charAt(right);
            int freq = tempMap.containsKey(newChar) ? tempMap.get(newChar) + 1: 1;
            tempMap.put(newChar,freq);
            if(tempMap.equals(map)){
                return true;
            }
        }

        return false;
    }
}
