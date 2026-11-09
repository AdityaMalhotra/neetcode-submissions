class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int result = 0;
        for(int right = 0;right<s.length();right++){
            Character current = s.charAt(right);
            while(set.contains(current)){
                Character old = s.charAt(left);
                set.remove(old);
                left++;
            }
            set.add(current);
            result = Math.max(result,right-left+1);
        }
        return result;
    }
}
