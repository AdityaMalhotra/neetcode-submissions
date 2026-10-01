class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> countMap = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            countMap.put(s.charAt(i),countMap.getOrDefault(s.charAt(i),0) + 1);
        }
        for(int i=0;i<t.length();i++){
            if(!countMap.containsKey(t.charAt(i))){
                return false;
            }
            countMap.put(t.charAt(i),countMap.get(t.charAt(i))-1);
            if(countMap.get(t.charAt(i)) <= 0){
                countMap.remove(t.charAt(i));
            }
        }
        if(countMap.size() > 0){
            return false;
        }
        return true;
    }
}
