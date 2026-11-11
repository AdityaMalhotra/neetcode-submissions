class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> parentMap = new HashMap<>();
        Map<Character,Integer> tempMap = new HashMap<>();
        for(char ch : s1.toCharArray()){
            parentMap.put(ch,parentMap.getOrDefault(ch,0) + 1);
        }
        int left = 0;
        for(int right = 0;right<s2.length();right++){
            if(right-left+1 > s1.length()){
                char toBeDiscarded = s2.charAt(left);
                int freq = tempMap.get(toBeDiscarded)-1;
                if(freq > 0){
                    tempMap.put(toBeDiscarded,freq);
                }else{
                    tempMap.remove(toBeDiscarded);
                }
                left++;
            }
            char current = s2.charAt(right);
            tempMap.put(current,tempMap.getOrDefault(current,0) + 1);
            if(parentMap.equals(tempMap)){
                return true;
            }
        }
        return false;
    }
}
