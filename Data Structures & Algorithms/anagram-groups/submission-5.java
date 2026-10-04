class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if(map.containsKey(sorted)){
                List<String> existingValue = map.get(sorted);
                existingValue.add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted,list);
            }
        }
        for(String key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}
