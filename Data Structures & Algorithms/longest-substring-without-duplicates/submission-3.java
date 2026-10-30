class Solution {
    public int lengthOfLongestSubstring(String s) {
        // dvdf
        // abcabcbb
        // abaac
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> charSet = new HashSet<>();
        while(left < s.length() && right<s.length()){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
}
