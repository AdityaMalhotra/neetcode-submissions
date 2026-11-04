class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        Map<Character,Integer> countMap = new HashMap<>();
        for(int i = 0;i <s1.length();i++){
            countMap.put(s1.charAt(i),countMap.getOrDefault(s1.charAt(i),0) + 1);
        }
        int left = 0;
        Map<Character,Integer> tempMap = new HashMap<>();

        for(int right = 0;right < s2.length();right++){
            if(right-left+1 > s1.length()){
                char toBeDiscarded = s2.charAt(left);
                int freq = tempMap.get(toBeDiscarded)-1;
                if(freq>0){
                    tempMap.put(toBeDiscarded,freq);
                }else{
                    tempMap.remove(toBeDiscarded);
                }
                left++;
            }
            char current = s2.charAt(right);
            tempMap.put(current,tempMap.getOrDefault(current,0) + 1);
            if(tempMap.equals(countMap)){
                return true;
            }
        }

        return false;
    }
}
