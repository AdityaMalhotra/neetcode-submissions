class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //ab lacabee
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        Map<Character,Integer> tempMap = new HashMap<>();

        int left = 0;
        for(int right = 0;right<s2.length();right++){
            char added = s2.charAt(right);
            int freq = tempMap.containsKey(added) ? tempMap.get(added) +1: 1;
            tempMap.put(added,freq);

            if(right-left+1 > s1.length()){//2-0 + 1 > 2 c
                char discarded = s2.charAt(left);
                int oldFreq = tempMap.get(discarded)-1;
                if(oldFreq < 1){
                    tempMap.remove(discarded);
                }else{
                    tempMap.put(discarded,oldFreq);
                }
                left++;
            }
            if(tempMap.equals(map)){
                return true;
            }
        }
        return false;
    }
}
